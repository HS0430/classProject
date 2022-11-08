<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-08
  Time: 오후 3:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calc</title>
</head>
<body>
  <form method="post" action="/CalcServlet">
    <input type="text" id="num1" name="num1">
    <input type="text" id="num2" name="num2">
    <button>전송</button>
  </form>
</body>
</html>
