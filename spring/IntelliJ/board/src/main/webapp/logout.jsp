<%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-12-05
  Time: 오후 3:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>
<%
  request.getSession().invalidate();
  response.sendRedirect("/login");
%>
</body>
</html>
