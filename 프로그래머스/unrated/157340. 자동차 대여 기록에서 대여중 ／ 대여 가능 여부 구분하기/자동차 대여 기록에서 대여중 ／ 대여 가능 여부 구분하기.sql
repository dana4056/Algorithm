-- 자동차ID, AVAILABILITY('대여중' OR '대여가능') 출력
-- 2022년 10월 16일에 대하여
-- 반납일 2022/10/16 인 경우 -> 대여중
-- V 자동차ID 내림차순

(SELECT DISTINCT CAR_ID, "대여중" AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16')
UNION ALL
(SELECT DISTINCT CAR_ID, "대여 가능" AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID NOT IN ((SELECT DISTINCT CAR_ID
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16')))
ORDER BY CAR_ID DESC
