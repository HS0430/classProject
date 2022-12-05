<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/css/assets/bootstrap.min.css" rel="stylesheet">
    <title>Board Register Page</title>
</head>
<body class="bg-light">
<div class="container">
    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
        <a href="#" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
            <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
            <span class="fs-4">#</span>
        </a>

        <ul class="nav nav-pills">
            <li class="nav-item"><a href="#" class="nav-link active" aria-current="page">Board</a></li>
            <li class="nav-item"><a href="#" class="nav-link">Member</a></li>
        </ul>
    </header>
    <div class="py-5 text-center">
        <h2>Board Register Form</h2>
    </div>
    <form method="post">
        <%
        String name = (String) session.getAttribute("loginName");
        %>
        <label for="writer" class="form-label">작성자</label>
        <input type="text" name="writer" id="writer" class="form-control" value="<%=name%>">
        <label for="title" class="form-label">제목</label>
        <input type="text" name="title" id="title" class="form-control">
        <label for="content" class="form-label">내용</label>
        <textarea name="content" id="content" class="form-control"></textarea>
        <input type="submit" value="등록" class="btn btn-primary" style="float: right">
        <a class="btn btn-primary" style="float: right" href="/board/list">취소</a>
    </form>


</div>
</body>
</html>
