-- 코드를 입력하세요
SELECT ROUND(AVG(DAILY_FEE),0) AS 'AVERAGE_FEE'
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE = 'SUV'



-- 평균 일일 대여 요금
-- 종류 SUV
-- 소수 첫번째 반올림
-- 컬럼명 AVERAGE_FEE


-- CAR_ID	 자동차 ID
-- CAR_TYPE	 자동차 종류 ('세단', 'SUV', '승합차', '트럭', '리무진' )
-- DAILY_FEE 일일 대여요금
-- OPTIONS   옵션리스트 -> 콤마로 구분 EX. '열선시트', '스마트키', '주차감지센서'