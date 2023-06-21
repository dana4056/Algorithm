-- 년, 월, 성별, 구매회원수
-- 년, 월, 성별 별로
-- 년 -> 월 -> 성별 오름차순
-- 성별 NULL 제외

SELECT DATE_FORMAT(SALES_DATE, "%Y") AS YEAR, DATE_FORMAT(SALES_DATE, "%m") AS MONTH, GENDER, COUNT(DISTINCT O.USER_ID) AS USERS
FROM ONLINE_SALE O JOIN USER_INFO U
ON U.USER_ID = O.USER_ID
WHERE GENDER IS NOT NULL
GROUP BY YEAR, MONTH, GENDER
ORDER BY YEAR, MONTH, GENDER


-- [USER_INFO] 
-- USER_ID      회원ID
-- GENDER       성별    -> (NULL, 0:남자, 1:여자)
-- AGE          나이  
-- JOINED       가입일

-- [ONLINE_SALE]
-- ONLINE_SALE_ID   판매ID
-- USER_ID          회원ID
-- PRODUCT_ID       상품ID
-- SALES_AMOUNT     판매량
-- SALES_DATE       판매일