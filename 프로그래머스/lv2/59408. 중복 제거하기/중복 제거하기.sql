-- 동물의 이름은 몇개?
-- NULL 집계 X
-- 중복제거
SELECT COUNT(DISTINCT NAME)
FROM ANIMAL_INS
WHERE NAME IS NOT NULL