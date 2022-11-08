<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-08
  Time: 오전 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>로그인 페이지</title>
</head>
<body>
<h1>로그인 페이지</h1>

  <%
    String userId = request.getParameter("userId");
    String userPwd = request.getParameter("userPwd");
    if(userId.equals(userPwd)){
      session.setAttribute("loginId", userId);
      response.sendRedirect("mypage.jsp");
    }
    else{
      response.sendRedirect("login.html");
    }

    LocalDate now = LocalDate.now();
  %>
<%= now%>
</body>
</html>
