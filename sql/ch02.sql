
-- ch02.sql

USE 세계무역;

-- *은 모든 컬럼을 가져온다.
SELECT * 
FROM 고객;

-- 출력되는 행의 개수
SELECT COUNT(*) AS '행의 갯수'
FROM 고객;

SELECT 고객번호,담당자명,고객회사명,마일리지 AS 포인트,
	마일리지 * 1.1 AS '10%인상된 마일리지'
FROM 고객;

SELECT 고객번호,담당자명,마일리지 AS 포인트
FROM 고객
WHERE 마일리지 >= 100000;

SELECT 고객번호,담당자명,도시,마일리지 AS 포인트
FROM 고객
WHERE 도시 = '서울특별시'
ORDER BY 마일리지 DESC;

-- limit 
SELECT *
FROM 고객
LIMIT 3;

-- 마일리지 상위 3명 / 하위 3명
SELECT *
FROM 고객
ORDER BY 마일리지 DESC
LIMIT 3;

SELECT *
FROM 고객
ORDER BY 마일리지 ASC
LIMIT 3;

-- 중복제거 distinct
SELECT DISTINCT 도시
FROM 고객;

-- 산술 연산자
SELECT 23 + 5 AS 더하기
	,23 - 5 AS 빼기
	,23 * 5 AS 곱하기
	,23 / 5 AS 실수나누기
	,23 DIV 5 AS 정수나누기
	,23 % 5 AS 나머지1
	,23 MOD 5 AS 나머지2;

-- 비교 연산자
SELECT 23 > 23
		,23 < 23
		,23 = 23
		,23 <> 23
		,23 != 23
		,23 >= 5
        ,23 <= 5;

SELECT * 
FROM 고객
WHERE 담당자직위 <> '대표 이사';

SELECT *
FROM 고객
WHERE 도시 = '부산광역시' AND 마일리지 < 1000;


-- 연습문제 DM제출
-- 1.‘서울’에 사는 고객 중에 마일리지가 15,000점 이상 20,000점 이하인 고객의 
--    모든 컬럼 정보를 보이시오.
SELECT *
FROM 고객
WHERE 도시 LIKE '%서울%'
AND (마일리지 >= 15000 AND 마일리지 <= 20000);

SELECT *
FROM 고객
WHERE 도시 LIKE '%서울%'
BETWEEN 15000 AND 20000;

-- 2. 세계무역의 고객들은 어느 지역, 어느 도시에 사는지 지역과 도시를 
-- 한 번씩만 보이시오.
--  이때 결과를 지역 순으로 나타내고, 동일 지역에 대해서는 도시 순으로 나타내시오.
-- DISTINCT는 두개의 컬럼에 적용
SELECT DISTINCT 지역, 도시
FROM 고객
ORDER BY 1, 2;

-- 값이 안보인다?
-- NULL인가? '' 빈칸인가? '   ' 공백인가?

-- 필수적으로 지역 컬럼을 NULL로 변경한다.
UPDATE 고객
SET 지역 = NULL
WHERE 지역 = '';

-- 3. ‘춘천시’나 ‘과천시’ 또는 ‘광명시’에 사는 고객 중에서 담당자직위에
--    ‘이사’ 또는 ‘사원’이 들어가는 고객의 모든 정보를 보이시오.
-- LIKE절
SELECT *
FROM 고객
WHERE 도시 = '춘천시' OR 도시 = '과천시' OR 도시 = '광명시'
AND (담당자직위 LIKE '%이사%' OR 담당자직위 LIKE '%사원%');

SELECT *
FROM 고객
WHERE 도시 IN ('춘천시', '과천시', '광명시')
AND (담당자직위 LIKE '%이사%' OR 담당자직위 LIKE '%사원%');

-- 4. ‘광역시’나 ‘특별시’에 살지 않는 고객들 중에서 마일리지가 
--    많은 상위 고객 3명의 모든 정보를 출력하시오.
SELECT *
FROM 고객
WHERE NOT (도시 LIKE '%광역시%' OR 도시 LIKE '%특별시%')
ORDER BY 마일리지 DESC 
LIMIT 3;

-- 5. 지역에 값이 들어있는 고객 중에서 담당자직위가 ‘대표 이사’인 고객을 빼고 보이시오.
--   (지역은 NULL 값으로 찍혀도 됩니다.)
SELECT *
FROM 고객
WHERE 지역 IS NOT NULL  
AND 담당자직위 <> '대표 이사';

SELECT *
FROM 고객;



