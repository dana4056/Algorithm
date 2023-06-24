-- 자동차 종류, 자동차수 출력
-- OPTIONS이 통풍시트, 열선시트, 가죽시트 중 하나 이상 포함
-- 자동차 종류 별
-- 자동차수 컬럼명 CARS
-- 자동차 종류 오름차순

SELECT CAR_TYPE, COUNT(CAR_ID) AS CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%통풍시트%'
OR OPTIONS LIKE '%열선시트%'
OR OPTIONS LIKE '%가죽시트%'
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE