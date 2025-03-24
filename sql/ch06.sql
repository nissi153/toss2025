-- ch06.sql

-- 서브쿼리 : SQL문 내부에서 사용하는 SELECT문

-- 단일행 서브쿼리
-- 최고 마일리지를 보유한 고객의 정보를 구하시오.
-- 최고 마일리지를 구하기
USE 세계무역;

SELECT MAX(마일리지)
FROM 고객;

SELECT *
FROM 고객
WHERE 마일리지 = 128790;

SELECT *
FROM 고객
WHERE 마일리지 = ( SELECT MAX(마일리지)
FROM 고객 ); -- 최대마일리지

-- 주문번호 'H0250'인 고객의 고객회사명, 담당자명을 출력하시오.
SELECT 고객번호
FROM 주문
WHERE 주문번호 = 'H0250';

SELECT 고객회사명, 담당자명
FROM 고객
WHERE 고객번호 = 'NARHA';

SELECT 고객회사명, 담당자명
FROM 고객
WHERE 고객번호 = ( SELECT 고객번호
					FROM 주문
					WHERE 주문번호 = 'H0250' );

-- 복수행 서브쿼리 : 복수행 비교연산자 IN, ANY(SOME), ALL, EXISTS

-- '부산광역시' 고객이 주문한 주문건수를 출력하기
-- IN : ~중의 하나라도 
SELECT 고객번호 FROM 고객
WHERE 도시 = '부산광역시'; -- 5행

SELECT COUNT(*) AS 주문건수
FROM 주문
WHERE 고객번호 = 'LIDBO';
                    
SELECT COUNT(*) AS 주문건수
FROM 주문
WHERE 고객번호 IN ( SELECT 고객번호 FROM 고객
                    WHERE 도시 = '부산광역시' );

-- ANY(SOME) :  마일리지 > 부산마일리지 OR ... OR ... OR                    
SELECT 담당자명, 고객회사명, 마일리지
FROM 고객
WHERE 마일리지 > ANY( SELECT 마일리지 FROM 고객
                      WHERE 도시 = '부산광역시' ); 

SELECT 담당자명, 고객회사명, 마일리지
FROM 고객
WHERE 고객번호 = 'TTMBO';
-- LIDBO LLIWE NGOHU RICPE TTMBO
-- 2819  806   7795   1177 7329

-- ALL :  AND ... AND ... AND 
SELECT AVG(마일리지) FROM 고객
GROUP BY 지역; -- 11025.51
                        
SELECT 담당자명, 고객회사명, 마일리지
FROM 고객
WHERE 마일리지 > ALL ( SELECT AVG(마일리지) FROM 고객 
                        GROUP BY 지역 );

-- EXISTS :  행의 존재여부로 비교
-- 주문이력이 있는 고객의 정보만 출력하기
SELECT 고객번호, 고객회사명
FROM 고객
WHERE EXISTS ( SELECT * FROM 주문 WHERE 고객번호 = 고객.고객번호 );


-- 인라인 뷰 : FROM절 안의 서브쿼리\
SELECT 도시, AVG(마일리지) AS 도시_평균마일리지
FROM 고객
GROUP BY 도시
ORDER BY AVG(마일리지) DESC;

SELECT 담당자명, 고객회사명, 마일리지, 고객.도시, 도시_평균마일리지,
       도시_평균마일리지 - 마일리지 AS 차이
FROM 고객,
     (
     	SELECT 도시, AVG(마일리지) AS 도시_평균마일리지
     	FROM 고객
     	GROUP BY 도시
     ) AS 도시별평균마일리지
WHERE 고객.도시 = 도시별평균마일리지.도시;

-- 스칼라 서브쿼리 : 메인 쿼리의 SELECT문안에 사용되는 서브쿼리
-- 행을 0개 반환하면 null이 되고, 2개이상 반환하면 오류 발생
SELECT MAX(주문일) 
FROM 주문
INNER JOIN 고객
WHERE 주문.고객번호 = 고객.고객번호;

SELECT 고객번호, 담당자명, (SELECT MAX(주문일) FROM 주문
                            WHERE 주문.고객번호 = 고객.고객번호) AS 최종주문일
FROM 고객;

-- CTE(Common Table Expression)
WITH 도시별요약 AS 
(
	SELECT 도시, AVG(마일리지) AS 도시_평균마일리지
	FROM 고객 
	GROUP BY 도시
)
SELECT 담당자명
      ,고객회사명
      ,마일리지
      ,고객.도시
      ,도시_평균마일리지
      ,도시_평균마일리지 - 마일리지 AS 차이
FROM 고객
	,도시별요약
WHERE 고객.도시 = 도시별요약.도시;



-- 연습문제
-- 1. ‘배재용’ 사원의 부서명을 보이시오.
-- 서브쿼리 또는 조인 방법으로 해결하시오.
SELECT 부서명
FROM 부서
WHERE 부서번호 = (SELECT 부서번호
                FROM 사원
                WHERE 이름 = '배재용'
                );
               
SELECT 사원.이름, 부서명
FROM 부서
INNER JOIN 사원
ON 부서.부서번호 = 사원.부서번호
WHERE 이름 = '배재용';

-- 2. 한번도 주문한 적이 없는 제품의 정보를 보이시오.
-- 서브쿼리 또는 조인 방법으로 해결하시오.
SELECT *
FROM 제품 AS p
WHERE NOT EXISTS (
                  SELECT *
                  FROM 주문세부 AS d
                  WHERE d.제품번호 = p.제품번호
				  );

SELECT 제품.*
FROM 제품
LEFT OUTER JOIN 주문세부
ON 제품.제품번호 = 주문세부.제품번호
WHERE 주문세부.제품번호 IS NULL;

-- 3. 담당자명, 고객회사명, 주문건수, 최초주문일과 최종주문일을 보이시오.
SELECT 담당자명
	  ,고객회사명
      ,주문건수
      ,최초주문일
      ,최종주문일
FROM 고객
    ,(SELECT 고객번호
            ,COUNT(*) AS 주문건수
            ,MIN(주문일) AS 최초주문일
            ,MAX(주문일) AS 최종주문일
     FROM 주문 
     GROUP BY 고객번호
     ) AS 주문요약
WHERE 고객.고객번호 = 주문요약.고객번호;

-- 실전문제

-- 1. 제품 테이블에 있는 제품 중 단가가 가장 높은 제품명은 무엇인가?
SELECT 제품명, 단가
FROM 제품 
WHERE 단가 = (SELECT MAX(단가) FROM 제품);

-- 2. 제품 테이블에 있는 제품 중 단가가 가장 높은 제품의 주문수량합은 얼마인가?
SELECT 제품명, SUM(주문세부.주문수량) AS 주문수량합
FROM 제품
INNER JOIN 주문세부
ON 제품.제품번호 = 주문세부.제품번호
WHERE 제품.단가 = (SELECT MAX(단가) FROM 제품)
GROUP BY 제품명;

-- 3. ‘아이스크림’ 제품의 주문수량합은 얼마인가?
SELECT sum(주문수량) AS 주문수량합 
FROM 주문세부
WHERE 주문세부.제품번호 IN 
	(SELECT 제품번호 FROM 제품
		WHERE 제품명 LIKE "%아이스크림%");

-- 4. ‘서울특별시’ 고객들에 대한 주문년도별 주문건수를 보이시오.
SELECT YEAR(주문일) AS 주문년도, COUNT(*) AS 주문건수 
FROM 주문
WHERE 고객번호 IN (SELECT 고객번호 FROM 고객
					WHERE 도시 = "서울특별시")
GROUP BY 주문년도
WITH ROLLUP;

