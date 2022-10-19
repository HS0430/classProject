-- 20221019
-- transaction : 일의 단위 => 여러 DML 들을 묶어둔 것
-- commit : 작업의 완료 => 데이터의 물리적 저장
-- rollback : 작업 실패 => 마지막 물리적 저장 상태로 복귀 (이전 마지막 commit 상태)

DROP TABLE dept02;

CREATE TABLE dept02 AS SELECT * FROM dept;
-- DDL 작업은 자동 COMMIT

SELECT * FROM dept02;

-- 트랜잭션의 시작
INSERT INTO dept02 VALUES(50, '개발', '서울');
INSERT INTO dept02 VALUES(60, '기획', '판교');
UPDATE dept02 SET loc='제주' WHERE deptno=60;

ROLLBACK;
COMMIT;

---------------------------
-- 가상 테이블 : VIEW
-- 데이터를 제한 할 수 있고, 복잡한 SQL을 단순하게 처리할 수 있다
-- 자주 사용되는 30번 부서에 소속된 사원들의 사번과 이름과 부서번호를 출력하기 위한 SELECT문을 하나의 뷰로 정의해 봅시다. 
SELECT empno, ename, deptno  FROM emp WHERE deptno=30;

-- VIEW  생성
CREATE OR REPLACE VIEW emp_view30
AS 
SELECT empno, ename, deptno FROM emp WHERE deptno=30;

SELECT * FROM emp_view30;
SELECT * FROM emp_view30 WHERE ename ='JAMES';

SELECT view_name, text
FROM USER_VIEWS;

DROP VIEW emp_view30;

-----------------------------
-- SEQUENCE : 자동 숫자 생성기
CREATE SEQUENCE dept_deptno_seq
START WITH 10
INCREMENT BY 10;

CREATE SEQUENCE emp_empno_seq;

SELECT emp_empno_seq.nextval FROM dual;

-- 새로운 값을 생성 : nextval -> 다음 값을 생성해서 반환
SELECT dept_deptno_seq.nextval FROM dual;
SELECT dept_deptno_seq.currval FROM dual;   -- 가장 마지막에 생성된 값

-- SEQUENCE 삭제
DROP SEQUENCE dept_deptno_seq;

CREATE TABLE dept04
AS 
SELECT * FROM dept
WHERE 1=0;

SELECT * FROM dept04;

INSERT INTO dept04 VALUES(dept_deptno_seq.nextval, '개발', '서울');
INSERT INTO dept04 VALUES((SELECT MAX(deptno) FROM dept04)+10, '개발', '서울');

------------------------------
-- INDEX : 검색의 성능을 향상 시킬 때 사용
DROP TABLE emp01;

CREATE TABLE emp01
AS 
SELECT * FROM emp;

INSERT INTO emp01 SELECT * FROM emp01;
INSERT INTO emp01(empno, ename) VALUES(1111, 'SON');
SELECT * FROM emp01 WHERE empno=1111;
SELECT * FROM emp01 WHERE ename='SON';

CREATE INDEX emp01_ename_idx ON emp01(ename);
CREATE INDEX emp01_empno_idx ON emp01(empno);

DROP INDEX emp01_empno_idx;
