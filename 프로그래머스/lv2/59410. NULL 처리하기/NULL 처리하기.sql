-- 생물종, 이름, 성별 및 중성화여부 조회 
-- 이름 NULL -> "No name"
-- 아이디 오름차순

SELECT ANIMAL_TYPE, IFNULL(NAME, "No name") AS NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID