-- 저자ID, 저자명, 카테고리, 매출액(판매량 * 판매가) 리스트 출력
-- 2022년 1월 판매 기준
-- 저자 ID 오름차순 -> 카테고리 내림차순

SELECT AUTHOR_ID, AUTHOR_NAME, CATEGORY, SUM(SALES * PRICE) AS TOTAL_SALES
FROM 
    (SELECT B.BOOK_ID, B.CATEGORY, B.AUTHOR_ID, B.PRICE, A.AUTHOR_NAME 
    FROM BOOK AS B 
    JOIN (SELECT * FROM AUTHOR ) AS A
    ON B.AUTHOR_ID = A.AUTHOR_ID) AS C 
    JOIN (SELECT * FROM BOOK_SALES)AS S
    ON S.BOOK_ID = C.BOOK_ID
WHERE DATE_FORMAT(SALES_DATE, "%Y-%m") = DATE_FORMAT("2022-01-00", "%Y-%m") 
GROUP BY CATEGORY, AUTHOR_NAME 
ORDER BY AUTHOR_ID, CATEGORY DESC