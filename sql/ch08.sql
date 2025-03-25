-- ch08.sql

-- DDL : 데이터 정의어

CREATE DATABASE IF NOT EXISTS 세계학사;

USE 세계학사;

CREATE TABLE 학과
    (
	   학과번호 CHAR(2)
      ,학과명 VARCHAR(20)
      ,학과장명 VARCHAR(20)
    );

INSERT INTO 학과 VALUES
     ('AA','컴퓨터공학과','배경민')
    ,('BB','소프트웨어학과','김남준')
    ,('CC','디자인융합학과','박선영');

SELECT * FROM 학과;

CREATE TABLE 학생(
	학번 CHAR(5)
	,이름 VARCHAR(20)
	,생일 DATE -- 2000-03-10
	,연락처 VARCHAR(20)
	,학과번호 CHAR(2) -- 외래키 
);

DESC 학생;

INSERT INTO 학생 -- (컬럼1,컬럼2, ...)
VALUES ('S0001', '이윤주', '2020-01-30', '01033334444', 'AA')
      ,('S0002', '이승은', '2021-02-23', NULL, 'AA')
      ,('S0003', '백재용', '2018-03-31', '01077778888', 'DD');

SELECT * FROM 학생;

-- 테이블의 구조와 데이터를 복사하기
CREATE TABLE 휴학생 AS 
SELECT * 
FROM 학생;

SELECT * FROM 휴학생;

DROP TABLE 휴학생;

-- 구조만 복사하기
CREATE TABLE 휴학생 AS 
SELECT * 
FROM 학생
WHERE 1 = 2; -- 항상 FALSE이다.

-- 계산된 결과를 저장하기
CREATE TABLE 회원 (
	아이디 VARCHAR(20) PRIMARY KEY
	,회원명 VARCHAR(20)
	,키 INT
	,몸무게 INT
	,체질량지수 DECIMAL(4, 1) AS (몸무게 / POWER(키/100, 2)) STORED
);
-- POWER(밑, 지수) 밑을 지수만큼 거듭제곱
-- STORED 테이블에 실제 저장
DESC 회원;

INSERT INTO 회원(아이디, 회원명, 키, 몸무게)
VALUES ('ARANG', '김아랑', 170, 55 );

SELECT * FROM 회원;

-- 테이블, 뷰, 인덱스의 속성 변경
-- ALTER 

ALTER TABLE 학생 ADD 성별 CHAR(1);
DESC 학생;
ALTER TABLE 학생 CHANGE COLUMN 연락처 휴대폰번호 VARCHAR(20);
ALTER TABLE 학생 DROP COLUMN 성별;
ALTER TABLE 학생 RENAME 졸업생;
DESC 졸업생;

-- 테이블, 뷰, 인덱스의 삭제
-- DROP
DROP TABLE 학과;
DROP TABLE 졸업생;

-- 제약조건
CREATE TABLE 학과( 
	학과번호 CHAR(2) PRIMARY KEY -- NOT NULL, UNIQUE
	,학과명 VARCHAR(20) NOT NULL -- NOT NULL
	,학과장명 VARCHAR(20) UNIQUE -- UNIQUE
);

DESC 학과;

INSERT INTO 학과 
VALUES ('01', '국어국문과', '홍교수');

INSERT INTO 학과 
VALUES ('01', '영어영문과', '데이비드교수'); -- UNIQUE

INSERT INTO 학과 
VALUES (NULL, '영어영문과', '데이비드교수'); -- NOT NULL

INSERT INTO 학과 
VALUES ('01', NULL, '홍교수'); -- NOT NULL

INSERT INTO 학과 
VALUES ('02', '수학과', '홍교수'); -- UNIQUE

DROP TABLE 학과;
CREATE TABLE 학과( 
	학과번호 CHAR(2)
	,학과명 VARCHAR(20)
	,학과장명 VARCHAR(20)
	,PRIMARY KEY(학과번호)
);
DESC 학과;

DROP TABLE 학과;
CREATE TABLE 학과( 
	학과번호 CHAR(2)
	,학과명 VARCHAR(20)
	,학과장명 VARCHAR(20)
);
ALTER TABLE 학과
ADD CONSTRAINT PK_학과 PRIMARY KEY(학과번호);
DESC 학과;

DROP TABLE 학생;
CREATE TABLE 학생(
	학번 CHAR(5) PRIMARY KEY
	,이름 VARCHAR(20) NOT NULL
	,생일 DATE NOT NULL
	,연락처 VARCHAR(20) UNIQUE
	,학과번호 CHAR(2) REFERENCES 학과(학과번호) -- 외래키 제약조건
	,성별 CHAR(1) CHECK(성별 IN ('남', '여'))
	,등록일 DATE DEFAULT(CURDATE())
	,FOREIGN KEY (학과번호) REFERENCES 학과(학과번호)
);

INSERT INTO 학과 
VALUES ('01', '국어국문과', '홍교수');
SELECT * FROM 학과;

INSERT INTO 학생 
VALUES ('S0001', '강감찬', '2000-02-03', '01022223333', '01', '남', NULL);
INSERT INTO 학생 
VALUES ('S0002', '사임당', '2000-02-03', '01044445555', '01', '여', NULL);
INSERT INTO 학생 (학번, 이름, 생일, 연락처, 학과번호, 성별)
VALUES ('S0003', '이순신', '2000-02-03', '01066667777', '01', '남'); -- DEFAULT
SELECT * FROM 학생;

CREATE TABLE 과목(
	과목번호 CHAR(5) PRIMARY KEY
	,과목명 VARCHAR(20) NOT NULL
	,학점 INT NOT NULL CHECK(학점 BETWEEN 2 AND 4)
	,구분 VARCHAR(20) CHECK(구분 IN ('전공', '교양', '일반'))
);
SELECT * FROM 과목;

CREATE TABLE 수강 (
	수강번호 INT PRIMARY KEY AUTO_INCREMENT
	,수강년도 CHAR(4) NOT NULL
	,수강학기 VARCHAR(20) NOT NULL
		CHECK( 수강학기 IN ('1학기','2학기','여름학기','겨울학기'))
	,학번 CHAR(5) NOT NULL
	,과목번호 CHAR(5) NOT NULL
	,성적 NUMERIC(3,1) CHECK(성적 BETWEEN 0 AND 4.5)
	,FOREIGN KEY(학번) REFERENCES 학생(학번)
	,FOREIGN KEY(과목번호) REFERENCES 과목(과목번호)
);
SELECT * FROM 학생;


INSERT INTO 학과
VALUES ('AA','컴퓨터공학과','배경민');

INSERT INTO 학과
VALUES ('AA','소프트웨어학과','김남준');

INSERT INTO 학과
VALUES ('CC','디자인융합학과','박선영');

SELECT * FROM 학과;

-- 오류수정
INSERT INTO 학과
VALUES ('BB','소프트웨어학과','김남준');


-- ON DELETE/UPDATE CASCADE
-- 참조하는 부모 테이블에서 삭제/수정이 일어날 때 자식 테이블도 자동으로 반영
DROP TABLE 학생; -- 외래키가 있는 테이블부터 먼저 삭제해야 됨.
DROP TABLE 학과;

CREATE TABLE 학과 (
  학과번호 CHAR(2) PRIMARY KEY,
  학과명 VARCHAR(20)
);
CREATE TABLE 학생 (
  학번 CHAR(5) PRIMARY KEY,
  이름 VARCHAR(20),
  학과번호 CHAR(2),
  FOREIGN KEY (학과번호) 
    REFERENCES 학과(학과번호)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

-- 학과 데이터
INSERT INTO 학과 VALUES ('01', '국어국문과');
INSERT INTO 학과 VALUES ('02', '컴퓨터공학과');

-- 학생 데이터
INSERT INTO 학생 VALUES ('S0001', '홍길동', '01');
INSERT INTO 학생 VALUES ('S0002', '이몽룡', '02');

SELECT * FROM 학생;
SELECT * FROM 학과;

-- 학생 테이블에서 '02'를 참조하던 '이몽룡'의 학과번호도 자동으로 '03'으로 바뀜
UPDATE 학과 SET 학과번호 = '03' WHERE 학과번호 = '02';

-- 학생 테이블에서 '01'을 참조하던 '홍길동' 학생도 자동 삭제됨
DELETE FROM 학과 WHERE 학과번호 = '01';



-- 연습문제
-- 1. 제품 테이블의 재고 컬럼에 CHECK 제약조건을 추가하시오
ALTER TABLE 제품 MODIFY COLUMN 재고 int CHECK(재고 >= 0);
-- 2. 제품 테이블에 재고금액 컬럼을 추가하시오. 
--    이 때 재고금액은 '단가 * 재고'가 자동계산되어 저장되도록 합니다.
ALTER TABLE 제품 ADD COLUMN 재고금액 int AS (단가*재고) STORED;
-- 3. 제품 테이블에서 제품 레코드를 삭제하면 
--    주문세부 테이블에 있는 관련 레코드도 함께 삭제되도록 
--    주문세부 테이블의 제품번호 컬럼에 외래키 제약조건과 옵션을 설정하시오.
ALTER TABLE 주문세부 ADD CONSTRAINT fk_제품번호 FOREIGN KEY (제품번호) REFERENCES 제품(제품번호) ON DELETE CASCADE;

-- 실전 문제
-- 1. 영화 테이블과 평점관리 테이블을 만들고자 합니다. 다음 테이블 명세서를 참고하여 테이블을 생성하시오.
CREATE TABLE 영화(
	영화번호 char(5) PRIMARY KEY,
	타이틀 varchar(100) NOT NULL,
	장르 varchar(20) CHECK(장르 IN ('코미디', '드라마', '다큐', 'SF', '액션', '역사', '기타')),
	배우 varchar(100) NOT NULL,
	감독 varchar(50) NOT NULL,
	제작사 varchar(150) NOT NULL,
	개봉일 date,
	등록일 date DEFAULT(curdate()),
);
-- 2. 다음 테이블 명세서를 참고하여 평점관리 테이블을 생성하시오.
CREATE TABLE 평점관리(
	번호 int AUTO_INCREMENT PRIMARY KEY,
	평가자닉네임 varchar(50) NOT NULL,
	영화번호 char(20) REFERENCES 영화(영화번호),
	평점 int CHECK(평점 BETWEEN 1 AND 5) NOT NULL,
	평가 varchar(2000) NOT NULL,
	등록일 date default(curdate()),
	FOREIGN KEY (영화번호) REFERENCES 영화(영화번호)
);
-- 3. 영화 테이블에 다음과 같이 데이터를 추가하시오.
INSERT INTO 영화 (영화번호, 타이틀, 장르, 배우, 감독, 제작사, 개봉일)
VALUES ('00001', '파묘', '드라마', '최민식, 김고은', '장재현', '쇼박스', '2024-02-22'),
	('00002', '듄:파트2', '액션', '티미시 샬라메, 젠데이아', '드니 뵐뇌브', '레전더리 픽처스', '2024-02-28');

-- 4. 평점관리 테이블에 다음과 같이 데이터를 추가하시오.
INSERT INTO 평점관리 (번호, 평가자닉네임, 영화번호, 평점, 평가)
VALUES (1, '영화광', '00001', 5, '미치도록 스릴이 넘쳐요'),
	(2, '무비러브', '00002', 4, '장엄한 스케일이 좋다');

-- 5. 영화번호를 00003으로도 새로운 레코드를 넣어서 오류 발생 여부를 확인하시오.
INSERT INTO 평점관리 (번호, 평가자닉네임, 영화번호, 평점, 평가)
VALUES (3, '영화광', '00003', 5, '미치도록 스릴이 넘쳐요');

-- 6. 영화테이블에서 레코드를 지우면 외래키 제약조건에 의해 오류가 발생하는지 확인하시오.
DELETE FROM 영화 WHERE 영화번호='00001';

-- 7. ON CASCADE 옵션을 통해 6번 문제를 해결하시오.
ALTER TABLE 평점관리 ADD CONSTRAINT fk_영화번호 FOREIGN KEY (영화번호) REFERENCES 영화(영화번호) ON DELETE CASCADE;





