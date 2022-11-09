<%@ page import="java.util.List" %>
<%@ page import="com.firstcoding.firstapp.member.Member" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: cheoho-hi
  Date: 2022-11-09
  Time: 오후 2:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
    List<Member> members = new ArrayList<>();
    members.add(new Member("cool00", "000", "COOL0"));
    members.add(new Member("cool01", "111", null));
    members.add(new Member("cool02", "222", "COOL2"));
    members.add(new Member("cool03", "333", "COOL3"));
    members.add(new Member("cool04", "444", null));
    members.add(new Member("cool05", "555", null));
    members.add(new Member("cool06", "666", "COOL6"));
    members.add(new Member("cool07", "777", null));
    members.add(new Member("cool08", "888", "COOL8"));
    members.add(new Member("cool09", "999", "COOL9"));

    session.setAttribute("members", members);
  %>
</body>
</html>
