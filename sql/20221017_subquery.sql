--43. 사원 번호가 7788인 사원과 담당 업무가 같은 사원을 표시(사원 이름과 담당업무)하시오.
SELECT ename, job
FROM emp
WHERE job=(SELECT job FROM emp WHERE empno='7788');

SELECT e1.ename, e1.job, e1.empno, e2.ename, e2.job, e2.empno
FROM emp e1, emp e2
WHERE e1.job = e2.job 
AND e2.empno ='7788';

--44. 사원번호가 7499인 사원보다 급여가 많은 사원을 표시하시오. 사원이름과 감당 업무
SELECT ename, job
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE empno='7499');

SELECT e1.ename, e1.job
FROM emp e1, emp e2
WHERE e1.sal > e2.sal
AND e2.empno='7499';

--45. 최소급여를 받는 사원의 이름, 담당업무 및 급여를 표시하시오. (그룹함수 사용)
SELECT ename, job, sal
FROM emp
WHERE sal = (SELECT MIN(sal) FROM emp );

--46. 평균급여가 가장 적은 직급의 직급 이름과 직급의 평균을 구하시오.
SELECT job, AVG(sal)
FROM emp
GROUP BY job
HAVING AVG(sal) = (SELECT MIN(AVG(sal)) FROM emp GROUP BY job);

--47. 각 부서의 최소 급여를 받는 사원의 이름, 급여, 부서번호를 표시하시오.
SELECT ename, sal, deptno
FROM emp
WHERE sal IN (SELECT MIN(sal) FROM emp GROUP BY deptno);

SELECT e1.ename, e1.sal, e1.deptno
FROM emp e1, (
                SELECT deptno, MIN(sal) AS sal
                FROM emp
                GROUP BY deptno
            ) e2
WHERE e1.deptno = e2.deptno
AND e1.sal IN e2.sal;

--48. 담당업무가 ANALYST 인 사원보다 급여가 적으면서 업무가 ANALYST가 아닌 사원들을 표시(사원번호, 이름, 담당 업무, 급여)하시오.
SELECT empno, ename, job, sal
FROM emp
WHERE sal < ALL (SELECT sal FROM emp WHERE job ='ANALYST')
AND job != 'ANALYST';

--49. 부하직원이 없는 사원의 이름을 표시하시오.
SELECT ename
FROM emp
WHERE empno NOT IN (SELECT NVL(mgr, 0) FROM emp);

SELECT *
FROM emp
WHERE empno NOT IN (
                SELECT DISTINCT(mgr) 
                FROM emp 
                WHERE mgr IS NOT NULL
);


--50. 부하직원이 있는 사원의 이름을 표시하시오.
SELECT ename
FROM emp
WHERE empno IN(SELECT DISTINCT(mgr) FROM emp);

SELECT *
FROM emp
WHERE empno IN (
                SELECT DISTINCT(mgr) 
                FROM emp 
                WHERE mgr IS NOT NULL
);

--51. BLAKE와 동일한 부서에 속한 사원의 이름과 입사일을 표시하는 질의를 작성하시오. ( 단 BLAKE는 제외 )
SELECT ename, hiredate
FROM emp
WHERE deptno = (SELECT deptno FROM emp WHERE ename = 'BLAKE')
AND ename != 'BLAKE';
--AND ename <> 'BLAKE';

--52. 급여가 평균 급여보다 많은 사원들의 사원 번호와 이름을 표시하되 결과를 급여에 대해서 오름차순으로 정렬하시오.
SELECT empno, ename, sal
FROM emp
WHERE sal > (SELECT AVG(sal) FROM emp)
ORDER BY sal;

--53. 이름에 K가 포함된 사원과 같은 부서에서 일하는 사원의 사원 번호와 이름을 표시하시오.
SELECT empno, ename
FROM emp
WHERE deptno IN (SELECT DISTINCT(deptno) FROM emp WHERE ename like '%K%');

--54. 부서위치가 DALLAS인 사원의 이름과 부서번호 및 담당업무를 표시하시오.
SELECT ename, deptno, job
FROM emp
WHERE deptno = (SELECT deptno FROM dept WHERE loc = 'DALLAS');

SELECT e.ename, e.deptno, e.job
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND loc = 'DALLAS';

--55. KING에게 보고하는 사원의 이름과 급여를 표시하시오.
SELECT ename, sal
FROM emp
WHERE mgr = (SELECT empno FROM emp WHERE ename ='KING');

--56. RESEARCH 부서의 사원에 대한 부서번호, 사원이름 및 담당 업무를 표시하시오.
SELECT deptno, ename, job
FROM emp
WHERE deptno = (SELECT deptno FROM dept WHERE dname ='RESEARCH');

--57. 평균 월급보다 많은 급여를 받고 
--이름에 M이 포함된 사원과 같은 부서에서 근무하는 사원의 
--사원 번호, 이름, 급여를 표시하시오.
SELECT empno, ename, sal
FROM emp
WHERE deptno IN (SELECT deptno FROM emp WHERE ename like '%M%')
AND sal > (SELECT AVG(sal) FROM emp);

--58. 평균급여가 가장 적은 업무를 찾으시오.
SELECT job, AVG(sal)
FROM emp
GROUP BY job
HAVING AVG(sal) = (SELECT MIN(AVG(sal)) FROM emp GROUP BY job);

--59. 담당업무가 MANAGER 인 사원이 소속된 부서와 동일한 부서의 사원을 표시하시오.
SELECT ename
FROM emp
WHERE deptno IN (SELECT deptno FROM emp WHERE job ='MANAGER');
