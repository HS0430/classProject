# 게시판
## 기술/구조
* JAVA 
* DBMS - Mysql
* ajax
* JavaScript
* CSS
* Spring
<br><br>

## 프로젝트 구조
JSP > Controller > Service > Mapper
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DTO
<br><br>

## 소스코드 
* [전체 소스코드](https://github.com/HS0430/miniProject)
<br><br>

## 프로젝트 PPT 
* [홀인원(스크린골프예약서비스)_ppt](https://docs.google.com/presentation/d/1q1pshaego0XhFUD0TwTGYZd-mw4B8lcc/edit?usp=sharing&ouid=103852431009940089839&rtpof=true&sd=true)
<br><br>

## 개인별 구현하면서 겪었던 어려움 
* **고민** <br>
설명<br>

* **문제** <br>
<b>1. 개발 범위 배분<br></b>
--> 각 메뉴별로 희망하는 기능 또는 임의로 배분<br>
<b>2. 한 파일을 동시 수정함으로써 충돌 문제<br></b>
--> 기능 별로 파일을 나누어 한 파일을 동일 수정하지 않게 함
<br>
<br>



## 테스트 안내 
**데이터베이스 초기세팅이 필요합니다.** 

**1. 데이터베이스 세팅 :**
* [데이터 베이스 계정 생성 및 테이블 및 SEQ 생성 링크](https://github.com/HS0430/miniProject/tree/main/sql)

* 오라클 계정 생성
>오라클 계정 생성 ('오라클계정생성.txt' 참조)

* 테이블 생성
> HALL 테이블 생성 ('hall.sql') <br>
> MEMBER 테이블 생성('member.sql') <br>
> RESERVATION 테이블 생성('reservation.sql')<br>
**RESERVATION 테이블은 마지막에 생성(HALL과 MEMBER의 키 = 외래키)<br>

* 시퀀스 생성
> MEMBERNO_SEQ 생성 ('memberno_seq.sql') <br>
> RESERVNO_SEQ 생성('reservno_seq.sql') <br>

**2. 관리자 계정 또는 사용자 계정 :** 
* Query<br> 
`INSERT INTO MEMBER VALUES(`<br>
`MEMBERNO_SEQ.nextval,`<br>
`'회원이름',`<br>
`'회원주소',`<br>
`'회원전화번호',`<br>
`'회원ID',`<br>
`'회원비밀번호',`<br>
`'회원등급_0:관리자_1:회원')`
<br><br>
