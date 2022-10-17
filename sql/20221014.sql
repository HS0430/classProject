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

-- 14 * 4 => cross join 의 결과 행
select * 
from emp CROSS JOIN dept;


SELECT emp.ename, dept.dname
FROM emp, dept
WHERE emp.deptno = dept.deptno;


-- 테이블 별칭을 이용해서 컬럼 구별
SELECT e.ename, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- mysql
SELECT e.deptno
FROM emp e INNER JOIN dept d
ON e.deptno=d.deptno;

SELECT *
FROM emp e INNER JOIN dept d
USING(deptno);

SELECT deptno
FROM emp e INNER JOIN dept d
USING(deptno);

SELECT *
FROM emp NATURAL JOIN dept;

SELECT *
FROM emp JOIN dept
ON emp.deptno=dept.deptno;

-- self Join : 자기 자신의 테이블과 조인
-- emp => mgr : 상사의 사원번호
-- 각 사원들의 이름과 상사의 이름을 출력

SELECT ename, mgr FROM emp;
SELECT ename FROM emp WHERE empno=7839;

SELECT e1.ename AS "사원이름", e2.ename AS "상사이름"
FROM emp e1 , emp e2
WHERE e1.mgr=e2.empno(+);

SELECT e1.ename, e2.ename
FROM emp e1 LEFT OUTER JOIN emp e2
ON e1.mgr=e2.empno;

SELECT e1.ename, e2.ename
FROM emp e1 RIGHT OUTER JOIN emp e2
ON e1.empno=e2.mgr;

-- 'SCOTT' 사원의 사원번호와 이름 직급 부서이름 부서위치를 출력
-- emp => 사원 번호, 이름, 직급
-- dept => 부서 이름, 위치

SELECT empno, ename, job, dname, loc
FROM emp e, dept d
WHERE e.deptno=d.deptno
AND e.ename='SCOTT';

SELECT empno, ename, job, dname, loc
FROM emp e JOIN dept d
ON e.deptno=d.deptno
WHERE ename='SCOTT';
--
SELECT *
FROM book JOIN orders
ON book.bookid=orders.bookid
JOIN customer
ON orders.custid=customer.custid;

-- salgrade 테이블을 참조해서 사원들의 사번, 이름, 급여, 급여 등급을 출력
SELECT * FROM salgrade;

SELECT ename, losal, sal, hisal , grade
FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal and s.hisal;

SELECT ename, losal, sal, hisal, grade
FROM emp e JOIN salgrade s
ON e.sal BETWEEN s.losal AND s.hisal;

-- 판내내역 : 판매 정보, 판매 서적의 정보, 고객의 정보
DESC orders;
DESC customer;

SELECT orders.orderdate, customer.name, book.bookname, book.price, orders.saleprice
FROM book, customer, orders
WHERE orders.custid=customer.custid AND orders.bookid=book.bookid
ORDER BY orders.orderdate DESC;

SELECT o.orderdate, c.name, b.bookname, b.price, o.saleprice
FROM orders o JOIN customer c
ON o.custid=c.custid
JOIN book b
ON o.bookid=b.bookid
WHERE name='박지성';

SELECT * FROM customer;

SELECT c.name, COUNT(*) AS "구매회수"
FROM orders o JOIN customer c
ON o.custid=c.custid
JOIN book b
ON o.bookid=b.bookid
GROUP BY c.name;
