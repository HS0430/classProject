<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-17
  Time: 오후 4:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Todo List Page</title>
</head>
<body>
    <h1>Todo List</h1>
    <hr>
    <table border="1" style="padding: 5px">
        <tr>
            <th>번호</th>
            <th>할일</th>
            <th>기간</th>
            <th>상태</th>
        </tr>
        <c:choose>
            <c:when test="${todoList == null || todoList.size() <= 0}">
                <tr>
                    <td colspan="4">입력된 데이터가 없습니다.</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach var="list" items="${todoList}">
                <tr>
                    <td>${list.tno}</td>
                    <td><a href="/todo/modify?tno=${list.tno}">${list.todo}</a></td>
                    <td>${list.dueDate}</td>
                    <td>${list.finished ? ' 완료' : '진행중'}</td>
                </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </table>
<a href="/todo/insert">등록</a>

</body>
</html>
