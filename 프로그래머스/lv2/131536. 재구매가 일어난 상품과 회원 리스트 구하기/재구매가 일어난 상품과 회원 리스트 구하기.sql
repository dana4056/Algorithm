-- 코드를 입력하세요
SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(*) > 1
ORDER BY USER_ID, PRODUCT_ID DESC


-- 회원 ID, 재구매한 상품 ID
-- 동일한 회원이 동일한 상품 재구매
-- 정렬1; 회원 ID 오름
-- 정렬2: 상품 ID 내림



-- ONLINE_SALE_ID, USER_ID, PRODUCT_ID, SALES_AMOUNT, SALES_DATE
-- 상품 판매 ID,    회원 ID,  상품 ID,     판매량,        판매일