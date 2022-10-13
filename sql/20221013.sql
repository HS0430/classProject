SELECT ename, sal, nvl(comm, 0) AS comm
FROM emp
WHERE comm >= 0;

-- 문자함수
-- LOWER (문자열) 소문자로 표현
SELECT LOWER('SCOTT') FROM dual;

SELECT ename, LOWER(ename) FROM emp;

-- UPPER (문자열) 대문자로 표현
SELECT UPPER('scott') FROM dual;

-- INITCAP (문자열) 첫 문자를 대문자로 표현
SELECT INITCAP('SCOTT') FROM dual;

-- SUBSTR (원본, 시작포인트, 반환할 개수) 지정된 만큼 문자열 표현
SELECT SUBSTR('안녕하세요. 손흥민입니다.', 2, 3) FROM dual;
SELECT SUBSTR('안녕하세요. 손흥민입니다.', 5) FROM dual;

-- LENGTH (문자열) 문자열의 길이 반환
SELECT LENGTH('안녕하세요. 손흥민입니다.') FROM dual;

-- LPAD, RPAD (원본, 자리수, 패턴) 특정 자리수 지정하고, 자리수에 데이터가 없는 경우 특정 패턴으로 채우는 함수
-- 00010, 00020, 00030
SELECT dname, LPAD(deptno, 5, 0), RPAD(deptno, 5, 'A') FROM dept;

-- TRIM (문자열) 
SELECT '     ABC', TRIM('     ABC') FROM dual;
SELECT '     ABC', TRIM('     ABC'), 'ABC     ', TRIM('ABC     '), '     ABC     ', TRIM('     ABC     ') FROM dual;

-- REPLACE (원본 문자열, 대상, 변경) 문자열 중 특정 문자를 변경
SELECT REPLACE('Steaven King', 'Steaven', 'S.') FROM dual;


-- 숫자함수
-- ABS(숫자) 절대값 반환
SELECT -1, ABS(-10) FROM dual;

-- FLOOR(숫자) 정수 반환, 소수점 X
SELECT 1, 1.1, 2.1, 2.9, FLOOR(2.9) FROM dual;

-- ROUND(숫자, 자리수) 반올림 (1 = 소수점 첫재짜리, -1 반대)
SELECT 1.2, 1.6, ROUND(1.2), ROUND(1.6), ROUND(234.517, 1), ROUND(235.517, -1) FROM dual;

-- TRUNC(숫자, 자리수) 버림 (1 = 소수점 첫재짜리, -1 반대)
SELECT 1234.567, TRUNC(1234.567), TRUNC(1234.567, 1), TRUNC(1234.567, -1)  FROM dual;

-- MOD (숫자, 숫자) 나머지값
SELECT MOD(1, 3), MOD(2, 3), MOD(3, 3), MOD(3, 0) FROM dual;


-- 날짜함수
-- SYSDATE 현재 날짜 출력
SELECT SYSDATE FROM dual;

-- MONTHS_BETWEEN (날짜, 날짜) 두 날짜간의 개월수 반환
SELECT MONTHS_BETWEEN(SYSDATE, '21/12/13') FROM dual;

-- ADD_MONTHS (날짜, 개월수) 날짜에 n개월 후를 반환
SELECT ADD_MONTHS(SYSDATE, 2) FROM dual;

-- NEXT_DAY (날짜, 숫자) 1:일, 2:월, 3:화 ... 
SELECT NEXT_DAY(SYSDATE, 2) FROM dual;

-- LAST_DAY (날짜) 해당 달의 마지막 날짜
SELECT LAST_DAY(SYSDATE) FROM dual;

-- SYSDATE를 반올림, SYSDATE에 시분초도 가지고 있으므로 12시가 지나면 다음날 반환
SELECT ROUND(SYSDATE) FROM dual;
-- SYSDATE를 버림, 해당 날짜 반환
SELECT TRUNC(SYSDATE) FROM dual;

-- 변환함수
-- TO_CHAR (원본, 'FORMAT'), 2022. 10. 13 14:39 (YYYY 년도, MM 월, DD 일, HH시 (HH24 24시), MI 분, SS 초)
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
        SYSDATE, TO_CHAR(SYSDATE, 'YYYY. MM. DD HH:MI:SS'),
        SYSDATE, TO_CHAR(SYSDATE, 'YYYY. MM. DD HH24:MI:SS')
FROM dual;
        
-- NUMBEr -> VARCHAR2
SELECT TO_CHAR(123456789, '000,000,000,000'),
        TO_CHAR(123456789, '999,999,999,999'),
        TO_CHAR(123456789, 'L999,999,999,999')
FROM dual;

SELECT ename, sal, TO_CHAR(sal*1400, 'L999,999,999,999') AS wonSal FROM emp;

-- VARCHAR2 -> DATE
-- TO_DATE(문자열, '날짜형식')
SELECT TO_DATE('19911213', 'YYYYMMDD'),
'1999-12-13', TO_DATE('1999-12-13', 'YYYY-MM-DD')
FROM dual;

-- VARCHAR2 -> NUMBER 해당 패턴의 문자열을 숫자로 변환
SELECT TO_NUMBER('20,000', '999,999') - TO_NUMBER('10,000', '999,999')
FROM dual;

-- DECODE => 여러가지 비교를 통해 결과 출력 switch-case와 유사
SELECT ename, deptno, 
decode(deptno, 10, 'ACCOUNTING'
            , 20, 'RESEARCH'
            , 30, 'SALES'
            , 40, 'OPERATIONS'
            ) as dname
FROM emp;

SELECT ename, job, sal, NVL(DECODE(job, 'ANALYST', sal*1.05
                                , 'SALESMAN', sal*1.1
                                , 'MANAGER', sal*1.15
                                , 'CLERK', sal*1.2 ), sal) as afterSal
FROM emp;

-- CASE ~ WHEN ~ THEN
SELECT ename, deptno, 
CASE 
    WHEN deptno=10 THEN 'ACCOUNTING'
    WHEN deptno=20 THEN 'RESEARCH'
    WHEN deptno=30 THEN 'SALES'
    WHEN deptno=40 THEN 'OPERATIONS'
END 
AS dname
FROM emp;

--------------------------------------------------------------------------------
-- 그룹함수, 집합함수, 집계함수, 다중행 함수
-- SUM 
-- (회사의 모든 사원의 급여 총액) 
SELECT SUM(sal) as totSal, COUNT(sal) FROM emp;
-- 커미션 총액
SELECT SUM(comm) as totComm, COUNT(comm), AVG(comm) FROM emp;

-- AVG
-- 급여 평균
SELECT ROUND(AVG(sal), 1) as avgSal FROM emp;

-- COUNT
-- 전체 사원 수
SELECT COUNT(*) FROM emp;
-- 전체 부서의 개수
SELECT COUNT(*) FROM dept;
-- 보유한 책의 개수
SELECT COUNT(*) FROM BOOK;
-- 고객의 수
SELECT COUNT(*) FROM CUSTOMER;
-- 판매량
SELECT COUNT(*) FROM ORDERS;
-- 직급의 수
SELECT COUNT(DISTINCT(job)) FROM emp;
-- 출판사 수
SELECT COUNT(DISTINCT(publisher)) FROM BOOK;

-- MAX
-- 최고 급여 찾기
SELECT MAX(sal) FROM emp;

-- MIN
-- 최저 급여 찾기
SELECT MIN(sal) FROM emp;

SELECT SUM(sal), COUNT(*) FROM emp WHERE deptno=10;
SELECT SUM(sal), COUNT(*) FROM emp WHERE deptno=20;
SELECT SUM(sal), COUNT(*) FROM emp WHERE deptno=30;
SELECT SUM(sal), COUNT(*) FROM emp WHERE deptno=40;

SELECT deptno, COUNT(*), SUM(sal), TRUNC(AVG(sal)), MAX(sal), MIN(sal), COUNT(comm)
FROM emp
GROUP BY deptno
-- 부서별 평균 급여가 2000이상인 데이터만 출력
HAVING AVG(sal) >= 2000;

SELECT deptno, MAX(sal), MIN(sal)
FROM emp
GROUP BY deptno
HAVING MAX(sal) >= 2900;

SELECT job, COUNT(*) 
FROM emp
GROUP BY job;