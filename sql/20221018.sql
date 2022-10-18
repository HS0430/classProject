-- 20221018
-- inline view -rownum
-- FROM 절 뒤에오는 서브쿼리 -> inline view
-- SELECT -> 결과도 테이블

SELECT * FROM emp;
SELECT rownum, emp.* FROM emp ORDER BY hiredate;

-- rownum : 사용자가 생성하는 컬럼이 아니다. 시스템에서 제공하는 컬럼
SELECT rownum, t.*
FROM (SELECT * FROM emp ORDER BY hiredate) t;

-- top3
-- 입사일이 가장 오래된 3명을 구하자
SELECT rownum, t.*
FROM (SELECT * FROM emp ORDER BY hiredate) t
WHERE rownum <= 3;

CREATE TABLE emp02
(
    empno NUMBER(4),       -- NOT NULL 제약 조건은 컬럼 정의 위치에서 제약조건을 정의
    ename VARCHAR2(10) CONSTRAINT emp02_ename_NN NOT NULL,
    job VARCHAR(9),
    sal NUMBER(7,2), -- 500~5000
    gender CHAR(1), -- 남자 M, 여자 F
    deptno NUMBER(2),
    hiredate DATE DEFAULT SYSDATE,
    CONSTRAINT emp02_empno_pk primary key (empno),
    CONSTRAINT emp02_job_uk unique(job),
    CONSTRAINT emp02_sal_ck CHECK (sal BETWEEN 500 AND 5000),
    CONSTRAINT emp02_gender_ck CHECK (gender in ('M', 'F')),
    CONSTRAINT emp02_deptno_fk foreign key (deptno) REFERENCES dept(deptno)
);

SELECT * FROM emp02;
DESC emp02;

INSERT INTO emp02 VALUES(1112, 'SON', '대리', 500, 'M', 40, '2022-10-18'); 
INSERT INTO emp02 (empno, ename) VALUES (1113, 'SCOTT'); -- 지정 입력되지 않은 컬럼에는 NULL 값이 등록 : 암묵적인 입력방법
INSERT INTO emp02 VALUES(1114, 'HOT', null, null, null, null, null); 

----------------------
-- 데이터의 수정
-- UPDATE 테이블이름 set 컬럼이름 = 새로운값, 컬럼이름=새로운값) WHERE 행 선택 조건

DROP TABLE emp03;

CREATE TABLE emp03 AS SELECT * FROM emp;


SELECT * FROM emp03;


-- 모든 사원의 부서번호를 30으로
UPDATE emp03 SET deptno = 30;

-- 모든 사원의 급여를 10% 인상하자
UPDATE emp03 SET sal = sal*1.1;

-- 모든 사원의 입사일을 오늘 날짜로 변경
UPDATE emp03 SET hiredate = SYSDATE;

-- 부서번호가 10번인 사원의 부서번호를 30번으로 변경
UPDATE emp03 SET deptno = 30 WHERE deptno =10;

-- 급여가 3000 이상인 사원들의 급여를 10% 인상
UPDATE emp03 SET sal= sal*1.1 WHERE sal >= 3000;

-- SCOTT 사원을 20번 부서로 이동, 직급을 MANAGER로 변경
UPDATE emp03 set deptno =40, job='MANAGER' WHERE ename = 'SCOTT';

-- SMITH 사원을 SCOTT 사원의 부서로 이동
UPDATE emp03 set deptno=(SELECT deptno FROM emp03 WHERE ename='SCOTT') WHERE ename='SMITH';

DROP TABLE dept01;
CREATE TABLE dept01 AS SELECT * FROM dept;
SELECT * FROM dept01;
-- 1. 부서 번호가 20번인 부서의 이름과 지역은 RESEARCH와 DALLAS입니다. 다음은 부서번호가 20인부서의 부서명과 지역명을 부서 번호가 40번인 부서와 동일하게 변경하기 위한 UPDATE 명령문입니다.
UPDATE dept01
SET (dname, loc) = (SELECT dname, loc FROM dept WHERE deptno=40)
WHERE deptno = 20;

---------------------------
-- 테이블의 행을 삭제
-- DELETE FROM 테이블이름 WHERE 행선택조건
-- DELETE 문으로 부서 테이블의 모든 행을 삭제
DELETE FROM dept01;
SELECT * FROM dept01;

SELECT * FROM emp03;
-- 대표 사퇴
DELETE FROM emp03 WHERE empno=7839;

-- 40번 부서의 모든 사원의 삭제
DELETE FROM emp03 WHERE deptno=40;

-- SALES 부서의 사원이 모드 퇴사 -> 삭제
DELETE FROM emp03 WHERE deptno = (SELECT deptno FROM dept WHERE dname='SALES');