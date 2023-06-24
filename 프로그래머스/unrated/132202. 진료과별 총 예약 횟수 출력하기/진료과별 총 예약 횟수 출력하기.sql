-- 진료과코드, 환자수
-- V 진료과코드 별
-- V 2022년 5월 예약
-- V 컬럼명: '진료과 코드', '5월예약건수'
-- V 환자수 오름차순 -> 진료과코드 오름차순

SELECT MCDP_CD AS '진료과코드', COUNT(*) AS '5월예약건수'
FROM APPOINTMENT
WHERE DATE_FORMAT(APNT_YMD, '%Y-%m') = '2022-05'
GROUP BY MCDP_CD
ORDER BY 5월예약건수 ASC, 진료과코드 ASC