-- 데이터베이스 생성
CREATE DATABASE IF NOT EXISTS blog;

-- 데이터베이스 선택
USE blog;

-- 테이블 생성
-- PRIMARY KYE : 기본키로 지정(UNIQUE, NOT NULL)
-- UNIQUE : 중복되는 않는 동일 컬럼 값
-- NOT NULL : NULL이 되면 안되는 값
-- AUTO_INCREMENT : 자동 증가 +1
CREATE TABLE posts(
	post_no INT(10) PRIMARY KEY AUTO_INCREMENT,
	post_title VARCHAR(50), -- 타이틀
	post_content VARCHAR(255) -- 내용
);
-- 테이블 구조 확인
DESC posts; 



CREATE TABLE comments(
	comment_no INT(10) PRIMARY KEY AUTO_INCREMENT,
	comment_content VARCHAR(255), -- 내용
  comment_post_no INT(10) -- post 아이디
);

DESC comments; 