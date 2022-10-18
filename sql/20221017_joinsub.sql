SELECT * FROM ORDERS;
SELECT * FROM CUSTOMER;
SELECT * FROM BOOK;
--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
--(5) 박지성이구매한도서의출판사수
SELECT COUNT(DISTINCT(b.publisher))
FROM orders o, book b, customer c
WHERE o.bookid = b.bookid
AND o.custid = c.custid
AND c.name ='박지성';

SELECT COUNT(DISTINCT(b.publisher))
FROM orders o, book b
WHERE o.bookid = b.bookid
AND o.custid = (SELECT custid FROM customer WHERE name = '박지성');

​
--(6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이
SELECT b.bookname, b.price, b.price-o.saleprice AS gap
FROM book b, orders o
WHERE b.bookid = o.bookid
AND o.custid = (SELECT custid FROM customer WHERE name = '박지성');

SELECT name, bookname, price, saleprice, price-saleprice
FROM orders o, book b, customer c
WHERE o.bookid = b.bookid
AND o.custid = c.custid
AND c.name = '박지성';

--(7) 박지성이구매하지않은도서의이름
SELECT bookname
FROM book
WHERE bookid NOT IN (
                    SELECT bookid 
                    FROM orders o, customer c 
                    WHERE o.custid = c.custid
                    AND c.name ='박지성'
                    );

--2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.
--(8) 주문하지않은고객의이름(부속질의사용)
SELECT c.custid, c.name
FROM customer c
WHERE custid NOT IN (SELECT DISTINCT(custid) FROM orders);
--WHERE NOT EXISTS (SELECT * FROM orders o WHERE c.custid = o.custid);

SELECT *
FROM customer c, orders o
WHERE c.custid = o.custid(+)
AND o.orderid IS NULL;

SELECT *
FROM customer c LEFT OUTER JOIN orders o
ON c.custid = o.custid
WHERE o.orderid IS NULL;


--(9) 주문금액의총액과주문의평균금액
SELECT SUM(SALEPRICE), AVG(SALEPRICE)
FROM orders;

--(10) 고객의이름과고객별구매액
SELECT name, NVL((SELECT SUM(saleprice) FROM orders WHERE custid = c.custid), 0) AS total
FROM customer c;

SELECT c.custid, c.name, SUM(saleprice)
FROM orders o, customer c
WHERE o.custid = c.custid
GROUP BY c.custid, c.name
ORDER BY c.custid;

--(11) 고객의이름과고객이구매한도서목록
SELECT (SELECT name FROM customer c WHERE c.custid = o.custid) AS name,
        (SELECT bookname FROM book b WHERE b.bookid = o.bookid) AS book
FROM orders o
ORDER BY name;

SELECT c.name, b.bookname
FROM customer c, orders o, book b
WHERE c.custid = o.custid
AND o.bookid = b.bookid
ORDER BY c.name;

--(12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문
SELECT a.*
FROM (SELECT o.orderid, o.custid, o.bookid, o.saleprice, o.orderdate, b.bookid AS bookid_1, b.bookname, b.publisher, b.price
        FROM book b, orders o
        WHERE b.bookid = o.bookid
        ORDER BY (price-saleprice) DESC
        ) a
WHERE rownum = 1;

SELECT o.orderid, o.custid, o.bookid, b.price, o.saleprice, o.orderdate, b.bookid AS bookid_1, b.bookname, b.publisher, b.price, price-saleprice
FROM orders o, book b
WHERE o.bookid = b.bookid
AND price-saleprice = (
                        SELECT MAX(price - saleprice)
                        FROM orders o, book b
                        WHERE o.bookid = b.bookid
                      );


--(13) 도서의판매액평균보다자신의구매액평균이더높은고객의이름
SELECT (SELECT name FROM customer c WHERE c.custid = o.custid) AS name, AVG(saleprice)
FROM orders o
GROUP BY custid
HAVING AVG(saleprice) > ALL (SELECT AVG(saleprice) FROM orders);

SELECT c.custid, name, AVG(saleprice)
FROM orders o, customer c
WHERE o.custid = c.custid
GROUP BY c.custid, name
HAVING AVG(saleprice) > (SELECT AVG(saleprice) FROM orders)
ORDER BY c.custid;
​
--3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.
--(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
-- 박지성이 구매한 도서의 출판사
SELECT b.publisher
FROM book b, orders o
WHERE b.bookid = o.bookid
AND o.custid = (SELECT custid FROM customer WHERE name ='박지성');

SELECT c.name, b.publisher
FROM book b, (SELECT * FROM customer c, orders o WHERE c.custid = o.custid) c
WHERE b.bookid = c.bookid
AND b.publisher IN (SELECT b.publisher
                        FROM book b, orders o
                        WHERE b.bookid = o.bookid
                        AND o.custid = (SELECT custid FROM customer WHERE name ='박지성')
                        )
AND c.name != '박지성';

SELECT DISTINCT(publisher)
FROM orders o, customer c, book b
WHERE o.custid = c.custid
AND o.bookid = b.bookid
AND name ='박지성';

SELECT *
FROM orders o, customer c, book b
WHERE o.custid = c.custid
AND o.bookid = b.bookid
AND publisher IN (
                    SELECT DISTINCT(publisher)
                    FROM orders o, customer c, book b
                    WHERE o.custid = c.custid
                    AND o.bookid = b.bookid
                    AND name ='박지성'
                 )
AND name <> '박지성';

--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
SELECT c.name
FROM customer c, (
                    SELECT COUNT(a.custid) as cnt, a.custid
                    FROM
                        (
                        SELECT b.publisher, o.custid
                        FROM book b, orders o, customer c
                        WHERE o.custid = c.custid
                        AND o.bookid = b.bookid
                        GROUP BY c.custid, b.publisher
                        ) a
                    GROUP BY custid
                 ) b
WHERE c.custid = b.custid
AND b.cnt >= 2;

SELECT o.custid, name
FROM orders o, customer c, book b
WHERE o.custid = c.custid
AND o.bookid = b.bookid
GROUP BY o.custid, name
HAVING COUNT(DISTINCT(publisher)) >= 2;