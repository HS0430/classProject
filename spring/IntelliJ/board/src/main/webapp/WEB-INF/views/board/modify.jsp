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
    <div class="d-flex align-items-center p-3 my-3 text-white bg-primary rounded shadow-sm">
        <h2>Board Register Form</h2>
    </div>
    <div class="my-3 p-3 bg-white rounded box-shadow">
    <form method="post">
        <%
        String name = (String) session.getAttribute("loginName");
        %>
        <input type="hidden" id="bno" name="bno" value="${board.bno}">
        <label for="writer" class="form-label">작성자</label>
        <input type="text" name="writer" id="writer" class="form-control" value="${board.writer}" readonly>
        <label for="title" class="form-label">제목</label>
        <input type="text" name="title" id="title" class="form-control" value="${board.title}">
        <label for="content" class="form-label">내용</label>
        <textarea name="content" id="content" class="form-control">${board.content}</textarea>
        <input type="submit" value="수정" class="btn btn-primary" style="float: right">
        <a class="btn btn-primary" style="float: right" href="/board/delete?bno=${board.bno}">삭제</a>
        <a class="btn btn-primary" style="float: right" href="/board/list">취소</a>
    </form>
    </div>
</div>
<div>

</div>
<div class="modal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p>Modal body text goes here.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
