-- ch05.sql

-- 조인 : 2개 이상의 테이블을 조회하여 하나의 결과를 반환.
-- ANSI SQL 문법을 사용하여, DBMS마다 SQL문의 호환이 가능하다.

-- 크로스 조인 : 테이블A와 테이블B의 모든 행의 조합
SELECT COUNT(*)
FROM 부서; -- 4

SELECT COUNT(*)
FROM 사원; -- 10

SELECT *
FROM 부서
CROSS JOIN 사원; -- 40


