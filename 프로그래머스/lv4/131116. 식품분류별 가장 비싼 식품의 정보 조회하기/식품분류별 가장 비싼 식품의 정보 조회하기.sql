-- 식품분류별 가장비싼 식품의 (식품분류, 가격, 이름)
-- 식품분류가 과자, 국, 김치, 식용유만
-- 식품 가격 내림차순
SELECT CATEGORY, PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE (CATEGORY, PRICE) IN
    (SELECT CATEGORY, MAX(PRICE)
    FROM FOOD_PRODUCT
    WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
    GROUP BY CATEGORY)
ORDER BY PRICE DESC