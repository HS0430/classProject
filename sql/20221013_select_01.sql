-- SELECT 문제풀이
--1. 덧셈연산자를 이용하여 모든 사원에 대해서 $300의 급여 인상을 계산한 후 사원의 이름, 급여, 인상된 급여를 출력하시오.
SELECT ename, sal, sal+300 
FROM emp;
​
--2. 사원의 이름, 급여, 연간 총 수입을 총 수입이 많은 것부터 작은 순으로 출력하시오, 연간 총수입은 월급에 12를 곱한 후 $100의 상여금을 더해서 계산하시오.
SELECT ename, sal, sal*12+100
FROM emp
ORDER BY sal*12+100 DESC;

--3. 급여가 2000을 넘는 사원의 이름과 급여를 표현, 급여가 많은 것부터 작은 순으로 출력하시오.
SELECT ename, sal
FROM emp
WHERE sal >= 2000
ORDER BY sal DESC;
​
--4. 사원번호가 7788인 사원의 이름과 부서번호를 출력하시오.
SELECT ename, deptno
FROM emp
WHERE empno = '7788';

--5. 급여가 2000에서 3000 사이에 포함되지 않는 사원의 이름과 급여를 출력하시오.
SELECT ename, sal
FROM emp
WHERE sal NOT BETWEEN 2000 AND 3000;
​
--6. 1981년 2월 20일 부터 1981년 5월 1일 사이에 입사한 사원의 이름, 담당업무, 입사일을 출력하시오.
SELECT ename, job, hiredate, dname
FROM emp e, dept d
WHERE hiredate BETWEEN '81/02/20' AND '81/05/01'
AND e.deptno = d.deptno;
​
--7. 부서번호가 20 및 30에 속한 사원의 이름과 부서번호를 출력, 이름을 기준(내림차순)으로 영문자순으로 출력하시오.
SELECT ename, deptno
FROM emp
WHERE deptno = '20' OR deptno = '30'
--WHERE DEPTNO IN(20, 30)
ORDER BY ename DESC;
​
--8. 사원의 급여가 2000에서 3000사이에 포함되고 부서번호가 20 또는 30인 사원의 이름, 급여와 부서번호를 출력, 이름순(오름차순)으로 출력하시오.
SELECT ename, sal, deptno 
FROM emp
WHERE (sal BETWEEN 2000 AND 3000) AND (deptno=20 OR deptno=30)
--WHERE sal BETWEEN 2000 AND 3000 AND deptno IN(20, 30)
ORDER BY ename ASC;
​
--9. 1981년도에 입사한 사원의 이름과 입사일을 출력하시오. (like 연산자와 와일드카드 사용)
SELECT ename, hiredate
FROM emp
WHERE hiredate like '81/%';
​
--10. 관리자가 없는 사원의 이름과 담당 업무를 출력하시오.
SELECT ename, job, dname
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND mgr is null;

--11. 커미션을 받을 수 있는 자격이 되는 사원의 이름, 급여, 커미션을 출력하되 급여 및 커미션을 기준으로 내림차순 정렬하여 표시하시오.
SELECT ename, sal, comm
FROM emp
WHERE comm IS NOT NULL AND comm != 0
ORDER BY sal, comm DESC;

--12. 이름의 세번째 문자가 R인 사원의 이름을 표시하시오.
SELECT ename
FROM emp
WHERE ename like '__R%';
​
--13. 이름에 A와 E를 모두 포함하고 있는 사원의 이름을 표시하시오.
SELECT ename
FROM emp
WHERE ename like '%A%' AND ename like '%E%';
​
--14. 담당업무가 CLERK, 또는 SALESMAN이면서 급여가 $1600, $950 또는 $1300이 아닌 사원의 이름, 담당업무, 급여를 출력하시오.
SELECT ename, dname, sal, job
FROM emp e, dept d
WHERE e.deptno = d.deptno
--AND (sal != '1600' AND sal !='950' AND sal != '1300')
AND sal NOT IN(1600, 950, 1300)
AND (job ='CLERK' OR job='SALESMAN');

--15. 커미션이 $500 이상인 사원의 이름과 급여 및 커미션을 출력하시오.
SELECT ename, sal, comm
FROM emp
WHERE comm >= '500';