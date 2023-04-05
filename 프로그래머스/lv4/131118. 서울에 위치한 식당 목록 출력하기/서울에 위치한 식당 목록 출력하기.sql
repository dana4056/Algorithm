-- 코드를 입력하세요
SELECT I.REST_ID, I.REST_NAME, I.FOOD_TYPE, I.FAVORITES, I.ADDRESS, ROUND(AVG(R.REVIEW_SCORE),2) AS SCORE
FROM REST_INFO AS I
JOIN REST_REVIEW AS R
ON I.REST_ID = R.REST_ID
WHERE I.ADDRESS LIKE "서울%" 
GROUP BY I.REST_ID
ORDER BY SCORE DESC, I.FAVORITES DESC




-- 식당 ID, 식당 이름, 음식 종류, 즐겨찾기수, 주소, 리뷰 평균 점수 출력
-- 서울 위치
-- 두개 테이블에서
-- 리뷰 평균점수 소수점 3번쨰에서 반올림
-- 정렬1: 평균점수 내림차순
-- 정렬2: 즐찾수 내림차순

-- [REST_INFO] 식당정보 테이블
-- REST_ID	    식당ID
-- REST_NAME    식당이름
-- FOOD_TYPE    음식 종류
-- VIEWS	    조회수
-- FAVORITES    즐겨찾기수
-- PARKING_LOT  주차장유무
-- ADDRESS	    주소
-- TEL          전화번호

-- [REST_REVIEW] 식당리뷰 테이블
-- REVIEW_ID    리뷰 ID
-- REST_ID	    식당 ID
-- MEMBER_ID    회원 ID
-- REVIEW_SCORE 점수
-- REVIEW_TEXT	리뷰 텍스트
-- REVIEW_DATE  작성일