-- 문자함수
-- UPPER 문자열 대문자
SELECT UPPER('scott') FROM dual;

-- LOWER 문자열 소문자
SELECT LOWER('SCOTT') FROM dual;

-- CONCAT 문자열 합치기
SELECT CONCAT('Steven', 'King') FROM dual;

-- REPLACE 특정 문자열 바꾸기
SELECT REPLACE('Steven King', 'Steven', 'S.') FROM dual;

-- FORMAT 값에 소수점 찍기
SELECT FORMAT('123456789', '000,000,000,000') FROM dual;

-- LPAD 왼쪽 부터 특정 값 채우기
SELECT LPAD(40, 5, '000') FROM dual;

-- RPAD 오른쪽 부터 특정 값 채우기
SELECT RPAD(40, 5, '000') FROM dual;

-- SUBSTR 문자열 자르기
SELECT SUBSTR('안녕하세요. 손흥민입니다.', 2) FROM dual;
SELECT SUBSTR('안녕하세요. 손흥민입니다.', 2, 8) FROM dual;
SELECT SUBSTRING('안녕하세요. 손흥민입니다.', 2) FROM dual;
SELECT SUBSTRING('안녕하세요. 손흥민입니다.', 2, 8) FROM dual;

-- TRIM 문자열 공백 없애기
SELECT '     ABC', trim('     ABC'), 'ABC          ', trim('ABC          '), '          ABC          ', trim('          ABC          ') FROM dual;

-- NOW 현재 시간 출력
SELECT NOW() FROM dual;


-- 숫자 함수
-- ABS 절대값
SELECT -10, ABS(-10) FROM dual;

-- FLOOR 소수점 없애기
SELECT 2.1, 2.9, FLOOR(2.9) FROM dual;

-- ROUND 반올림
SELECT 1234.567, ROUND(1234.527, 1), ROUND(1235.527, -1), ROUND(1235.527) FROM dual;

-- TRUNCATE 오라클 TRUNC 
SELECT 1234.567, TRUNCATE(1234.567, 0), TRUNCATE(1234.567, 1), TRUNCATE(1234.567, -1) FROM dual;

-- MOD 나머지 값 MySQL에서 0나누기 결과 값은 null
SELECT MOD(1,3), MOD(2,3), MOD(3,3), MOD(0,3), MOD(3,0) FROM dual;

-- 날짜 시간 함수
-- 현재 시간
SELECT CURDATE(), CURTIME(), NOW(), SYSDATE(), CURRENT_TIMESTAMP() FROM dual;

-- YEAR 년도, MONTH 월, DAY 일, HOUR 시, MINUTE 분, SECOND 초
SELECT YEAR(NOW()), MONTH(NOW()), DAY(NOW()), HOUR(NOW()), MINUTE(NOW()), SECOND(NOW()) FROM dual;

-- DATE 년월일 TIME 시분초
SELECT DATE(NOW()), TIME(NOW()) FROM dual;

-- ADDDATE 특정 일수 만큼 추가하여 반환, SUBDATE 특정 일수만큼 감소하여 반환
SELECT ADDDATE(NOW(), 10), SUBDATE(NOW(), 10) FROM dual;

-- ADDTIME 특정 시간만큼 추가하여 반환, SUBTIME 특정 시간만큼 감소하여 반환
SELECT ADDTIME(NOW(), 10), SUBTIME(NOW(), 10) FROM dual;

-- DATEDIFF 날짜1 - 날짜2 결과 / TIMEDIFF 날짜1 또는 시간1 - 날짜2 또는 시간2
SELECT DATEDIFF(NOW(), '2022-01-01'), TIMEDIFF(CURTIME(), '00:00:00') FROM dual;

-- LAST_DAY 해당 날짜(월)의 마지막 일
SELECT LAST_DAY(NOW()) FROM dual;

-- 변환
-- STR_TO_DATE
SELECT STR_TO_DATE('20220517', '%Y%m%d') FROM dual;

-- DATE_FORMAT
SELECT DATE_FORMAT(NOW(), '%Y. %m. %d %H:%i:%s') FROM dual;