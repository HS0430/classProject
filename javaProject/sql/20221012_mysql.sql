SELECT sal, comm
FROM emp;

-- null 값을 치환하는 함수 : ifnull()
SELECT sal, ifnull(comm, 0)
FROM emp;

SELECT sal+100
FROM emp;

SELECT ename, job
FROM emp;

-- 문자열을 완성하는 함수 : concat(arg, arg, arg ......)
SELECT CONCAT(ename, ' is a ', job)
FROM emp;