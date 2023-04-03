-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER, date_format(date_of_birth, '%Y-%m-%d') as DATE_OF_BIRTH
FROM member_profile
WHERE gender = 'W' 
and month(date_of_birth) = 3
and tlno is not null 
order by member_id 



-- 회원의 ID, 이름, 성별, 생년월일 조회
-- 3월생, 여성
-- 전화번호 not null
-- 회원 ID로 오름차순