-- 코드를 입력하세요
SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK
WHERE CATEGORY = '인문' AND DATE_FORMAT(PUBLISHED_DATE, '%Y') = '2021'
ORDER BY PUBLISHED_DATE


-- 도서 ID, 출판일 출력
-- 2021에 출판
-- 인문 카테고리
-- 출판일 기준 오름차순
