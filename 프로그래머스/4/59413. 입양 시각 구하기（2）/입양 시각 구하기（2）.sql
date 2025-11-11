-- 1. 재귀

WITH RECURSIVE hours AS (
    -- 초기값
    SELECT 0 AS h
    -- 
    UNION ALL
    -- 재귀 부분
    SELECT h + 1 
    FROM hours
    -- 기저 조건
    WHERE h < 23   
)

SELECT h.h AS HOUR, COUNT(o.ANIMAL_ID) AS COUNT
FROM hours h
LEFT JOIN ANIMAL_OUTS o
ON h.h = HOUR(o.DATETIME)
GROUP BY h.h
ORDER BY h.h
