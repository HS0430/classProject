<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-24
  Time: 오후 3:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>사원 리스트 페이지</title>
</head>
<body>
    <h1>사원 리스트</h1>
    <hr>
    <form>
        <select name="searchType">
            <option value="empno">사원번호</option>
            <option value="ename">사원명</option>
            <option value="job">업무</option>
            <option value="deptno">부서번호</option>
        </select>
        <input type="text" name="keyword">
        <input type="submit" value="검색">
    </form>
    <table border="1">
      <tr>
        <th>사원번호</th>
        <th>사원명</th>
        <th>업무</th>
        <th>담당</th>
        <th>입사일</th>
        <th>급여</th>
        <th>COMM</th>
        <th>부서번호</th>
        <th>관리</th>
      </tr>
      <c:forEach items="${emplist}" var="emp">
      <tr>
        <td>${emp.empno}</td>
        <td>${emp.ename}</td>
        <td>${emp.job}</td>
        <td>${emp.mgr}</td>
        <td>${emp.hiredate}</td>
        <td>${emp.sal}</td>
        <td>${emp.comm}</td>
        <td>${emp.deptno}</td>
        <td><a href="/emp/update?empno=${emp.empno}" style="text-decoration: none">수정</a><a onclick="deleteEmp(${emp.empno})" style="cursor: pointer">삭제</a></td>
      </tr>
      </c:forEach>
    </table>
<a href="/emp/insert">사원 등록</a>
    <script>
      function deleteEmp(no){
        if(confirm("삭제하시겠습니까?")){
          location.href = '/emp/delete?empno='+no;
        }
      }
    </script>
</body>
</html>
