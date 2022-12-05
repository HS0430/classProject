<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/css/assets/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/js/board/board.js"></script>
    <title>Title</title>
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
        <h2>Board List Form</h2>
    </div>
    <table class="table">
        <thead>
        <tr class="table-primary">
            <th scope="col" width="10%">#</th>
            <th scope="col" width="54%">제목</th>
            <th scope="col" width="12%">작성자</th>
            <th scope="col" width="12%">작성일</th>
            <th scope="col" width="12%">수정일</th>
        </tr>
        </thead>
        <tbody id="blist">
        </tbody>
    </table>
    <div class="toolbar-bottom">
        <div class="toolbar mt-lg">
            <div class="sorter" id="psorter" name="psorter">
            </div>
        </div>
    </div>
    <select name="searchType" id="searchType" class="form-control-sm">
        <option value="title">제목</option>
        <option value="writer">작성자</option>
    </select>
    <input type="text" name="keyword" id="keyword" class="form-control-sm">
    <button class="btn btn-primary" name="searchBtn" id="searchBtn"> 검색 </button>
    <a class="btn btn-primary" style="float: right" href="/board/reg">등록</a>
</div>
</body>
</html>
