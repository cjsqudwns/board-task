<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 상세보기</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500;700&family=Pretendard&display=swap"
          rel="stylesheet">
    <link href="/css/layout.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<%@ include file="../layout/header.jsp" %>

<main class="view-container">
    <div class="view-header">
        <h1>${board.title}</h1>
        <p class="writer-info">작성자: <strong>${board.user.name}</strong></p>
    </div>

    <div class="view-content">
        <p>${board.content}</p>
    </div>

    <div class="view-footer">
        <a href="/board/list">← 목록으로</a>
    </div>
</main>

<%@ include file="../layout/footer.jsp" %>

</body>
</html>