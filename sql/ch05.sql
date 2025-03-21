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

SELECT 부서.부서번호, 부서명, 이름, 사원.부서번호
FROM 부서
CROSS JOIN 사원
WHERE 이름 = '배재용';


-- INNER 조인 : 두 테이블 사이의 공통된 값을 기준으로 결과를 반환
--   1. 등가조인(이퀴 조인) : = 등호로 조인한다.
--   2. 비등가조인(논이퀴 조인) : 등호 외 비교 연산자로 조인한다.

-- '이소미'사원의 사원번호,직위,부서번호,부서명을 출력하시오.
-- 사원테이블, 부서테이블 2개를 조회한다.
SELECT 사원번호, 직위, 사원.부서번호, 부서명
FROM 사원
INNER JOIN 부서
ON 사원.부서번호 = 부서.부서번호
WHERE 이름 = '이소미';



-- 조인 + GROUP BY절
SELECT 고객.고객번호, 담당자명, 고객회사명, COUNT(*) AS 주문건수
FROM 고객
INNER JOIN 주문
ON 고객.고객번호 = 주문.고객번호
GROUP BY 1, 2, 3
ORDER BY COUNT(*) DESC;

-- 3개의 테이블에서 INNER 등가조인 예)
-- 고객번호별로 주문금액합을 구하자.
SELECT 고객.고객번호, 담당자명, 고객회사명, SUM(주문수량 * 단가) AS 주문금액합
FROM 고객
INNER JOIN 주문
ON 고객.고객번호 = 주문.고객번호
INNER JOIN 주문세부
ON 주문.주문번호 = 주문세부.주문번호
GROUP BY 1, 2, 3
ORDER BY 4 DESC; 

DESC 고객;
DESC 마일리지등급;

SELECT * 
FROM 마일리지등급;

-- INNER 조인 : 비등가조인
SELECT 고객번호, 고객회사명, 담당자명, 마일리지, 등급명
FROM 고객
INNER JOIN 마일리지등급
ON 마일리지 BETWEEN 하한마일리지 AND 상한마일리지
WHERE 담당자명 = '이은광';


-- OUTER JOIN : 조건(등가,비등가)에 맞지 않는 행도 결과값으로 나옴.
SELECT *
FROM 부서;

SELECT *
FROM 사원
WHERE 부서번호 = 'A4';

SELECT 부서명, 사원.*
FROM 사원
INNER JOIN 부서
ON 사원.부서번호 = 부서.부서번호;

-- 사원 테이블에 홍보부 부서번호가 없다.
-- 사원 테이블에 정수진 부서번호가 없다.

-- 사원 테이블에서 부서번호가 null인 행도 출력한다.
SELECT 부서명, 사원.*
FROM 사원
RIGHT OUTER JOIN 부서
ON 사원.부서번호 = 부서.부서번호;

-- 부서번호가 null인 사원만 출력한다.
SELECT 이름, 부서.*
FROM 사원
LEFT OUTER JOIN 부서
ON 사원.부서번호 = 부서.부서번호
WHERE 부서.부서번호 IS NULL; 

