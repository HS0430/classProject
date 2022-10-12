-- 20221012
SELECT *
FROM emp;

-- select distinct 컬럼 이름, 컬럼 이름, ...
-- from 테이블의 이름

SELECT * FROM dept; -- 행을 선택하는 조건이 없기 때문에 모든 행이 결과로 출력

SELECT deptno, dname FROM dept;

SELECT sal, nvl(comm, 0) FROM emp;

-- null : 정해지지 않은 값

-- select의 표현 영역에서는 산술연산이 가능
SELECT sal + comm
FROM emp;

SELECT sal, sal - 100
FROM emp;

SELECT sal * 12
FROM emp;

SELECT sal / 2 
FROM emp;

-- 사원 테이블에서 사원의 이름, 월 급여, 연봉을 출력
SELECT ename, sal, sal*12, sal*12+comm
FROM emp;

-- null의 값을 치환해주는 함수 : nvl(원본데이터, null 일때 치환 되는 값)
SELECT ename, sal, comm, sal*12, sal*12+nvl(comm, 0)
FROM emp;

SELECT ename, sal, sal*12 AS yearSal, sal*12+nvl(comm,0) as yearSal2
FROM emp;

-- 문자열 연산
SELECT ename || ' is a ' || job
FROM emp;

--distinct : 중복된 데이터를 생력하고 출력
SELECT deptno
FROM emp;

SELECT DISTINCT deptno
FROM emp;

-- 행을 찾는 조건
-- SELECT
-- FROM
-- WHERE 조건식 <- 행을 찾는 조건식
SELECT * 
FROM emp 
WHERE sal >= 3000;

-- 부서 테이블에서 부서번호가 10번인 사원의 리스트를 출력
--deptno=10
SELECT * 
FROM emp
WHERE deptno=10;

-- 10번 부서 소속이 아닌 사원들의 리스트 출력
SELECT * 
FROM emp
WHERE deptno!=10;  -- 또는 <>

-- 이름으로 검색 => 문자열 작은 따옴표로 표시
-- ename = 'SCOTT'
SELECT *
FROM emp
WHERE ename = 'SCOTT';   -- 지정된 문자열은 대소문자를 구별하기 때문에 주의 'scott' 결과 X

SELECT *
FROM emp
WHERE hiredate='81/11/17';   -- 날짜 비교시에도 작은 따옴표로 사용해서 비교

-- 논리 연산 => 비교연산을 여러개 사용해서 결과를 만든다.
-- AND, OR NOT

-- 10번부서의 매니어 (직급)을 검색하자 emp
SELECT *
FROM emp
WHERE JOB = 'MANAGER' AND deptno = 10;

-- 10번 부서에 소속한 사원들과 매니저들을 출력하자
SELECT *
FROM emp
WHERE deptno = 10 OR job='MANAGER';

-- 10번부서 소속이 아닌 사원들의 리스트 출력
SELECT * 
FROM emp
WHERE NOT deptno = 10;

-- 10번 부서 소속인 사원들 중에서 직급이 MANAGER인 사람을 검색하여 사원명, 부서번호, 직급을 출력
-- 하려고 한다면 두 가지 조건을 제시해야 합니다. 
SELECT ename, deptno, job
FROM emp
WHERE deptno=10 AND job='MANAGER';

-- 10번 부서에 소속된 사원이거나 직급이 MANAGER인 사람을 검색하여 사원명, 부서번호, 직급을 출력 합시다. 
SELECT ename, deptno, job
FROM emp
WHERE deptno=10 OR job='MANAGER';

-- 2000 에서 3000사이의 급여를 받는 사원의 리스트
SELECT *
FROM emp
WHERE sal >= 2000 AND sal <= 3000;  

SELECT *
FROM emp
WHERE sal BETWEEN 2000 AND 3000;

-- 1987년에 입사한 사원 리스트
SELECT *
FROM emp
WHERE hiredate BETWEEN '87/01/01' AND '87/12/31';

-- 커미션이 300 이거나 500이거나 1400인 사원을 검색하기
SELECT * 
FROM emp
WHERE comm = 300 OR comm = 500 OR comm = 1400;

SELECT * 
FROM emp
WHERE comm in(300, 500, 1400, 0);

-- 이름 검색 : ename like 'SC'
-- like 패턴 검색
-- 이름을 'F'로 시작하는 이름을 검색
SELECT * 
FROM emp
WHERE ename like 'F%';
--WHERE ename like '%N';
--WHERE ename like 'S%';

-- 이름의 두번째 글자가 A인 사원 검색
SELECT * 
FROM emp
WHERE ename like '_A%';

-- null 여부를 확인하는 is null
-- null 비교연산자를 사용할 수 없다 = null x
SELECT * 
FROM emp
WHERE comm is null OR comm=0;

-- 커미션이 등록된 사원의 리스트
SELECT * 
FROM emp
WHERE comm is not null;

-- 결과 행의 정렬 : order by 컬럼 asc | desc
-- asc : 오름 차순, 생략하면 기본값
-- desc : 내림차순

-- 급여 컬럼을 기준으로 오름차순으로
SELECT *
FROM emp
-- where 
ORDER BY sal DESC;  --ASC

-- 사원 리스트를 이름 순으로 출력
SELECT *
FROM emp
ORDER BY ename DESC;

-- 입사일이 가장 오래된 사원 순으로 사원의 리스트를 출력
SELECT *
FROM emp
ORDER BY hiredate;

-- 가장 최근 입사자부터 출력하는 리스트
SELECT *
FROM emp
ORDER BY hiredate DESC, job ASC;

SELECT * 
FROM emp
ORDER BY sal, ename DESC;
