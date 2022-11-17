<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-17
  Time: 오후 5:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <title>Todo Insert Page</title>
  <style>
    body {
      line-height: 250%;
    }
  </style>
</head>
<body>
<h1>Todo Insert</h1>

<form method="post">
  <table>
    <tr>
      <td>할일</td>
      <td><input type="text" name="todo"></td>
    </tr>
    <tr>
      <td>기한</td>
      <td><input type="date" name="dueDate"></td>
    </tr>
    <tr>
      <td></td>
      <td><input type="reset">
        <input type="submit" value="등록">
      </td>
    </tr>
  </table>
</form>
</body>
</html>