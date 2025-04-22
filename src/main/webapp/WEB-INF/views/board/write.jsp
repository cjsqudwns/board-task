<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 작성 / 수정</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500;700&family=Pretendard&display=swap"
          rel="stylesheet">
    <link href="/css/layout.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<%@ include file="../layout/header.jsp" %>

<main class="list-container">
    <h2>${board != null ? '게시글 수정' : '게시글 작성'}</h2>

    <form action="${board != null ? '/board/edit' : '/board/write'}" method="post" class="form-wrapper">
        <c:if test="${board != null}">
            <!-- 수정 시 기존 게시글 ID를 숨겨서 전달 -->
            <input type="hidden" name="bid" value="${board.bid}"/>
        </c:if>
        <div class="form-group">
            <label for="title">제목</label>
            <!-- 게시글 수정일 경우에는 기존 제목을, 새 글 작성일 경우에는 빈 폼을 표시 -->
            <input type="text" id="title" name="title" value="${board != null ? board.title : ''}" required/>
        </div>

        <div class="form-group">
            <label for="content">내용</label>
            <!-- 게시글 수정일 경우에는 기존 내용을, 새 글 작성일 경우에는 빈 폼을 표시 -->
            <textarea id="content" name="content" rows="8" required>${board != null ? board.content : ''}</textarea>
        </div>

        <div class="btn-pos">
            <button type="submit" class="btn btn-primary">${board != null ? '수정' : '저장'}</button>
            <a href="/board/list" class="btn btn-cancel">목록으로</a>
        </div>
    </form>
</main>

<%@ include file="../layout/footer.jsp" %>

</body>
</html>