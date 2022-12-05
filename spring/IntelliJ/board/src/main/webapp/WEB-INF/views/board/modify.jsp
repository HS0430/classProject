<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/css/assets/bootstrap.min.css" rel="stylesheet">
    <script src="/js/board/board_modify.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

    <title>Board Modify Page</title>
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
            <li class="nav-item"><a href="/logout.jsp" class="nav-link">Logout</a></li>
        </ul>
    </header>
    <div class="d-flex align-items-center p-3 my-3 text-white bg-primary rounded shadow-sm">
        <h2>Board Modify Form</h2>
    </div>
    <form method="post">
    <div class="my-3 p-3 bg-white rounded box-shadow">
        <%
        String name = (String) session.getAttribute("loginName");
        %>
        <input type="hidden" id="realName" name="realName" value="<%=name%>">
        <input type="hidden" id="bno" name="bno" value="${board.bno}">
        <label for="writer" class="form-label">작성자</label>
        <input type="text" name="writer" id="writer" class="form-control" value="${board.writer}" readonly>
        <label for="title" class="form-label">제목</label>
        <input type="text" name="title" id="title" class="form-control" value="${board.title}">
        <label for="content" class="form-label">내용</label>
        <textarea name="content" id="content" class="form-control">${board.content}</textarea>
    </div>
        <div style="text-align: right">
        <input type="submit" value="수정" class="btn btn-primary" id="boardModifyBtn">
        <a class="btn btn-primary" href="/board/delete?bno=${board.bno}" id="boardDeleteBtn">삭제</a>
        <a class="btn btn-primary" href="/board/list">취소</a>
        </div>
    </form>
    <div class="my-3 p-3 bg-white rounded box-shadow" style="display: block">
        <h6 class="border-bottom border-gray pb-2 mb-0">
            댓글 <label id="replyCount"></label>
            <span class="btn btn-link" id="replyAddBtn" name="replyAddBtn" style="float: right; text-decoration: none">New Reply</span>
        </h6>
        <div id="reply_area">
        </div>
    </div>
</div>

<div class="modal" tabindex="-1" id="replymodal" style="background-color: #00000066">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">댓글 작성</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" id="rmClose"></button>
            </div>
            <div class="modal-body">
                <input type="hidden" id="replyBno" name="replyBno" value="${board.bno}">
                <input type="hidden" id="replyWriter" name="replyWriter" value="${board.writer}">
                <input class="form-control" type="text" id="replyContent" name="replyContent">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="rmReg">등록</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="rmClose2">Close</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
