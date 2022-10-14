-- 20221014
-- JOIN ; 관계있는 테이블의 스키마를 붙이는 것
SELECT *
FROM emp, dept;
--WHERE emp.deptno = dept.deptno;

-- CROSS JOIN 결과
SELECT * 
FROM emp CROSS JOIN dept;

SELECT emp.ename, dept.dname
FROM emp, dept
WHERE emp.deptno = dept.deptno;

SELECT e.ename, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno;