<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 목록</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500;700&family=Pretendard&display=swap"
          rel="stylesheet">
    <link href="/css/layout.css" rel="stylesheet" type="text/css"/>

</head>
<body>

<%@ include file="../layout/header.jsp" %>

<main class=list-container>
    <h2>게시글 목록</h2>
    <table border="1">
        <tr>
            <th>No</th>
            <th>제목</th>
            <th>글쓴이</th>
        </tr>
        <c:if test="${not empty requestScope.boards}">
            <c:forEach var="b" items="${boards}">
                <tr>
                    <td>${b.bid}</td>
                    <td><a href="/board/view?id=${b.bid}">${b.title}</a></td>
                    <td>${b.user.name}</td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${empty requestScope.boards}">
            <tr>
                <td colspan="5">
                    <p align="center"><b><span style="font-size:12pt;">등록된 게시물이 존재하지 않습니다.</span></b></p>
                </td>
            </tr>
        </c:if>
    </table>
    <div class="btn-pos">
        <a href="/board/write" class="btn btn-primary">글쓰기</a>
    </div>
</main>

<%@ include file="../layout/footer.jsp" %>

</body>
</html>
