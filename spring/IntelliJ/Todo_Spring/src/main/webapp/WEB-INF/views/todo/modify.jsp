<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-21
  Time: 오후 5:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Modify Page</title>
</head>
<body>
<form method="post">
  <table>
    <tr>
      <td>번호</td>
      <td><input type="text" name="tno" value="${param.tno}" readonly></td>
    </tr>
    <tr>
      <td>할일</td>
      <td><input type="text" name="todo" value="${todo.todo}"></td>
    </tr>
    <tr>
      <td>기한</td>
      <td><input type="date" name="dueDate" value="${todo.dueDate}"></td>
    </tr>
    <tr>
      <td>상태</td>
      <td><input type="checkbox" name="finished" value="1" ${todo.finished ? 'checked' : ''}></td>
    </tr>
    <tr>
      <td></td>
      <td><input type="reset">
        <input type="submit" value="modify">
      </td>
    </tr>
  </table>
</form>
<form action="/todo/remove" method="post">
  <input type="hidden" name="tno" value="${param.tno}">
  <input type="submit" value="Remove">
</form>
</body>
</html>
