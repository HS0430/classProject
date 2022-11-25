<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-24
  Time: 오후 4:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>사원 등록 페이지</title>
</head>
<body>
    <h1>사원 등록</h1>
    <hr>
    <form method="post">
    <table>
      <tr>
        <td>사원번호</td>
        <td><input type="number" name="empno" id="empno"></td>
      </tr>
      <tr>
        <td>사원명</td>
        <td><input type="text" name="ename" id="ename"></td>
      </tr>
      <tr>
        <td>업무</td>
        <td><input type="text" name="job" id="job"></td>
      </tr>
      <tr>
        <td>담당</td>
        <td><input type="number" name="mgr" id="mgr"></td>
      </tr>
      <tr>
        <td>입사일</td>
        <td><input type="date" name="hiredate" id="hiredate"></td>
      </tr>
      <tr>
        <td>급여</td>
        <td><input type="text" name="sal" id="sal"></td>
      </tr>
      <tr>
        <td>COMM</td>
        <td><input type="text" name="comm" id="comm"></td>
      </tr>
      <tr>
        <td>부서번호</td>
        <td>
          <select name="deptno" id="deptno">
          <c:forEach items="${dept}" var="dept">
            <option value="${dept.deptno}">${dept.deptno} / ${dept.dname}</option>
          </c:forEach>
          </select>
          </td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="등록"></td>
      </tr>
    </table>
    </form>
</body>
</html>
