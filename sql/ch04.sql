-- ch04.sql
-- 집계합수(다중행 함수) : COUNT(), SUM(), AVG(), MIN(), MAX()

SELECT COUNT(*) -- null을 포함한 모든 행의 개수 
FROM  고객;

-- 컬럼의 개수는 null을 빼고 집계한다.
SELECT COUNT(고객번호), COUNT(도시), COUNT(지역)  
FROM 고객;

SELECT SUM(마일리지), AVG(마일리지), MIN(마일리지), MAX(마일리지)
FROM 고객;

SELECT SUM(마일리지), AVG(마일리지), MIN(마일리지), MAX(마일리지)
FROM 고객
WHERE 도시 = '서울특별시';

-- GROUP BY절 - 특정 컬럼에 대한 집계를 할때
SELECT *
FROM 고객;

SELECT 도시
		,COUNT(*) AS '도시별 고객수'
		,AVG(마일리지) AS '도시별 평균마일리지'
FROM 고객
GROUP BY 도시;

SELECT 도시
		,COUNT(*) AS '도시별 고객수'
		,AVG(마일리지) AS '도시별 평균마일리지'
FROM 고객
GROUP BY 1;

-- 두개 이상의 컬럼에 대한 집계
SELECT 담당자직위
      ,도시
      ,COUNT(*) AS 고객수
      ,AVG(마일리지) AS 평균마일리지
FROM 고객
GROUP BY 1, 2
ORDER BY 1, 2;

-- HAVING절 : SELECT문에 들어가는 컬럼과 집계함수에만 적용 가능.
SELECT 도시
      ,COUNT(*) AS 고객수
      ,AVG(마일리지) AS 평균마일리지
FROM 고객
GROUP BY 도시
HAVING COUNT(*) >= 10; 

SELECT 도시
      ,COUNT(*) AS 고객수
      ,AVG(마일리지) AS 평균마일리지
FROM 고객
WHERE 도시 LIKE '%광역시'
GROUP BY 도시
HAVING COUNT(*) >= 3; 

-- where절과 having절을 함께 사용하는 예
SELECT 도시,담당자직위,SUM(마일리지)
FROM 고객
WHERE 고객번호 LIKE 'T%'
GROUP BY 1,2
HAVING SUM(마일리지) >= 1000;
-- GROUP BY절에는 SELECT문의 컬럼명을 모두 넣어야 됨.
