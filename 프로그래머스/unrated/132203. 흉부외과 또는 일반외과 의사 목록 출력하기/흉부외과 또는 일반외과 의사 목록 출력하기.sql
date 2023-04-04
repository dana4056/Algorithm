-- 코드를 입력하세요
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d')
FROM DOCTOR
WHERE MCDP_CD = 'CS' OR MCDP_CD = 'GS'
ORDER BY HIRE_YMD DESC, DR_NAME;


-- 이름, ID, 진료과, 고용일자 조회
-- 진료과: CS, GS
-- 고용일자 기준으로 내림차순
-- 2번째 정렬 -> 이름 오름차순

-- DR_NAME	의사이름
-- DR_ID	의사 ID
-- LCNS_NO	면허번호
-- HIRE_YMD 고용일자 
-- MCDP_CD	진료과코드
-- TLNO	    전화번호