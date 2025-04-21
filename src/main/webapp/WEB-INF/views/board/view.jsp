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
    <h2>상세보기</h2>

    <table class="view-table">
        <tr>
            <th>번호</th>
            <td>${board.bid}</td>
            <th>작성일</th>
            <td>2024-04-21</td>
            <%--            <td>${board.createdAt}</td>--%>
        </tr>
        <tr>
            <th>이름</th>
            <td>${board.user.name}</td>
            <th>조회수</th>
            <td>10</td>
            <%--            <td>${board.views}</td>--%>
        </tr>
        <tr>
            <th>제목</th>
            <td colspan="3">${board.title}</td>
        </tr>
        <tr>
            <td colspan="4" class="content-cell">
                ${board.content}
            </td>
        </tr>
    </table>

    <div class="btn-pos">
        <c:if test="${true}">
            <%--            <c:if test="${board.user.id == sessionScope.loginUser.id}">--%>
            <a href="/board/edit?bid=${board.bid}" class="btn btn-edit">수정</a>
            <form action="/board/delete" method="post" style="display:inline;">
                <input type="hidden" name="_method" value="delete"/>
                <input type="hidden" name="bid" value="${board.bid}"/>
                <button type="submit" class="btn btn-delete">삭제</button>
            </form>
        </c:if>
        <a href="/board/list" class="btn btn-list">목록</a>
    </div>
</main>

<%@ include file="../layout/footer.jsp" %>

</body>
</html>