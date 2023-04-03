-- 코드를 입력하세요
SELECT PT_NAME, PT_NO, GEND_CD, AGE,  
CASE 
    WHEN TLNO IS NULL THEN 'NONE' 
    ELSE TLNO
END
FROM PATIENT
WHERE AGE <= 12 AND GEND_CD = 'W'
ORDER BY AGE DESC, PT_NAME;


-- 환자이름, 환자번호, 성별, 나이, 전화번호
-- 12이하, 여자
-- 전화번호 없을 땐, NONE 출력
-- 나이 기준 내림차순
-- 나이 같으면 환자이름 기준 오름차순