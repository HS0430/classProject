--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
--(3) 박지성의총구매액(박지성의고객번호는1번으로놓고작성)
SELECT SUM(SALEPRICE)
FROM orders
WHERE CUSTID = '1';
--WHERE CUSTID = (SELECT custid FROM customer WHERE name = '박지성');

--(4) 박지성이구매한도서의수(박지성의고객번호는1번으로놓고작성)
SELECT COUNT(*)
FROM orders
WHERE CUSTID = 1;
--WHERE CUSTID = (SELECT custid FROM customer WHERE name = '박지성');

--2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.
--(1) 마당서점도서의총개수
SELECT COUNT(*)
FROM book;

--(2) 마당서점에도서를출고하는출판사의총개수
SELECT COUNT(DISTINCT(publisher))
FROM book;