-- 데이터베이스 생성
CREATE DATABASE IF NOT EXISTS mydb;

-- 데이터베이스 선택
USE mydb;

-- 테이블 생성
-- PRIMARY KYE : 기본키로 지정(UNIQUE, NOT NULL)
-- UNIQUE : 중복되는 않는 동일 컬럼 값
-- NOT NULL : NULL이 되면 안되는 값
-- AUTO_INCREMENT : 자동 증가 +1
CREATE TABLE member(
	member_no INT(10) PRIMARY KEY AUTO_INCREMENT,
	member_id VARCHAR(50), -- 로그인 아이디
	member_pw VARCHAR(50), -- 로그인 암호
	member_nickname VARCHAR(50) -- 닉네임
);
-- 테이블 구조 확인
DESC member; 

-- 행/레코드 추가
INSERT INTO `member`(member_no, member_id, member_pw, member_nickname)
VALUES (1, 'hong', '1234', '홍길동');

-- 모든 컬럼의 데이터를 기입하면, 필드이름 생략 가능
INSERT INTO `member` VALUES (2, 'lee', '1234', '이순신');

-- auto_increment 속성 컬럼은 0이면, 자동증가함.
INSERT INTO `member` VALUES (0, 'su', '1234', '수선화');

-- 레코드 수정하기
UPDATE `member` SET member_id='hong2', member_pw='2222' WHERE member_no = 1;

-- 레코드 삭제하기
DELETE FROM `member` WHERE member_no = 1;

-- 데이터 조회
SELECT * FROM `member`;
-- 백틱 : 예약어일 수도 있는 사용자 정의어를 사용할 때

-- MySQL : auto commit - 파일에 적용이 바로 된다.
-- ORACLE : manual commit - commit 명령을 내려야 된다.
COMMIT;








