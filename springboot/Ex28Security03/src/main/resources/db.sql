create database mydb;

-- 1. DB 연결
USE mydb;

-- 회원가입 DB 만들기
-- 1.테이블 삭제
drop table member_security;

-- 2.테이블 생성
create table member_security(
	id          BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	username 	VARCHAR(255) NOT NULL,
	password    VARCHAR(255) NOT NULL,
    user_name   VARCHAR(255),
    user_role   VARCHAR(255) DEFAULT 'ROLE_USER',
    join_date   DATE DEFAULT (current_date)
);


-- 3. ROW 추가 : 회원가입 화면에서 직접 입력하자. 암호키가 달라짐.
-- https://bcrypt.online/
-- https://bcrypt-generator.com/
-- BCryptPasswordEncoder : 1234 => $2y$10$WYvjTTKkSnFf9gBilGM8WepiPMF6a9T2oXc/4KzuhwSYnqyV.BHrK
-- insert into member_security( id, username, password, user_name, user_role, joindate )
--       values ( 0, 'hong', '$2y$10$WYvjTTKkSnFf9gBilGM8WepiPMF6a9T2oXc/4KzuhwSYnqyV.BHrK', '홍길동', 'ROLE_USER', '2022/09/09');
-- insert into member_security( id, username, password, user_name, user_role, joindate )
--      values ( 0, 'tom', '$2y$10$WYvjTTKkSnFf9gBilGM8WepiPMF6a9T2oXc/4KzuhwSYnqyV.BHrK', '톰아저씨', 'ROLE_USER', '2022/09/09' );
-- insert into member_security( id, username, password, user_name, user_role, joindate )
--      values ( 0, 'admin', '$2y$10$WYvjTTKkSnFf9gBilGM8WepiPMF6a9T2oXc/4KzuhwSYnqyV.BHrK', '관리자', 'ROLE_ADMIN', '2022/09/09' );

-- 4. 검색하기
select * from member_security;

-- 5. 커밋하기
-- commit;