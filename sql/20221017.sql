-- 20221017
-- 서브쿼리
-- SCOTT이 소속된 부서이름 출력
SELECT d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND e.ename = 'SCOTT';

-- 서브 쿼리 이용한 부서 찾기
SELECT dname
FROM dept d
WHERE deptno = (SELECT deptno FROM emp WHERE ename='SCOTT');

-- 스칼라 부속 질의
SELECT custid,
(SELECT name FROM customer c where c.custid=o.custid) AS CUSTNAME
FROM orders o
GROUP BY custid;

SELECT name FROM customer WHERE custid = 1;

-- 마당서점의 고객별 판매액을 보이시오
-- 결과는 고객이름과 고객별 판매액을 출력
SELECT 
(SELECT name FROM customer c WHERE c.custid = o.custid) AS name,
custid, SUM(saleprice) as total
FROM orders o
group by custid;

-- 인라인뷰 : FROM 절 뒤에 쓰여지는 서브쿼리 => 가상 테이블
SELECT o.custid, sum(saleprice)
FROM orders o,
(SELECT custid, name FROM customer WHERE custid <= 2) c
WHERE c.custid = o.custid
GROUP BY o.custid;

SELECT *
FROM (SELECT empno, ename, job, hiredate FROM emp)
WHERE ename ='SCOTT';

-- 평균 급여보다
-- 더 많은 급여를 받는 사원을 검색하는
SELECT *
FROM emp
WHERE sal > 
(SELECT AVG(sal) FROM emp);
-- 평균 급여
SELECT AVG(sal) FROM emp;

-- 평균 주문금액 이하의 주문에 대해서 주문번호와 금액을 보이시오.
SELECT orderid, saleprice
FROM orders
WHERE saleprice <= (SELECT AVG(saleprice) FROM orders);
-- 평균 주문금액
SELECT AVG(saleprice) FROM orders;

-- 각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서 
-- 주문번호, 고객번호, 금액을 보이시오.
SELECT orderid, custid, saleprice
FROM orders
WHERE saleprice > (SELECT AVG(saleprice) FROM orders);
-- 평균 주문금액
SELECT AVG(saleprice) FROM orders;

-- 주어진 문제가 3000 이상 받는 사원이 소속된 부서(10번, 20번)와 
-- 동일한 부서에서 근무하는 사원이기에 서브쿼리의 결과 중에서 
-- 하나라도 일치하면 참인 결과를 구하는 
SELECT * 
FROM emp
--WHERE deptno =? OR deptno =? ...
WHERE deptno IN(
SELECT DISTINCT(deptno)
FROM emp
WHERE sal >= 3000
);
-- 3000이상 받는 사원이 소속된 부서번호
SELECT DISTINCT(deptno)
FROM emp
WHERE sal >= 3000;

-- 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오. 
SELECT SUM(saleprice)
FROM orders
WHERE custid in(select custid from customer WHERE address like '%대한민국%');
-- 대한민국에 거주하는 고객
select custid from customer WHERE address like '%대한민국%';

-- 3번 고객이 주문한 도서의 
-- 최고 금액보다 더 비싼 도서를 구입한 주문의 
-- 주문번호와 금액을 보이시오
-- ALL 연산자는 모든 값이 true
SELECT orderid, saleprice
FROM orders
WHERE saleprice > ALL(SELECT saleprice FROM orders WHERE custid=3);
-- 3번 고객이 주문한 도서의 금액
SELECT saleprice FROM orders WHERE custid=3;

SELECT orderid, saleprice
FROM orders
WHERE saleprice > (SELECT MAX(saleprice) FROM orders WHERE custid=3);
-- 3번 고객이 주문한 도서의 최고금액
SELECT MAX(saleprice) FROM orders WHERE custid=3;

-- EXISTS 연산자로 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오
SELECT SUM(saleprice)
FROM orders o
WHERE EXISTS (SELECT * FROM customer c WHERE c.custid = o.custid AND address like '%대한민국%');
-- 대한민국의 거주하는 고객
SELECT * FROM customer c, orders o WHERE c.custid = o.custid AND address like '%대한민국%';