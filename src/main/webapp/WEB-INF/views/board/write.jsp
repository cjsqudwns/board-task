<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 작성</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500;700&family=Pretendard&display=swap"
          rel="stylesheet">
    <link href="/css/layout.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<%@ include file="../layout/header.jsp" %>

<main class="list-container">
    <h2>게시글 작성</h2>

    <form action="/board/write" method="post" class="form-wrapper">
        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" id="title" name="title" required/>
        </div>
        
        <div class="form-group">
            <label for="title">작성자 ID</label>
            <input type="text" id="user_id" name="user_id" required/>
        </div>

        <div class="form-group">
            <label for="content">내용</label>
            <textarea id="content" name="content" rows="8" required></textarea>
        </div>

        <div class="form-actions">
            <button type="submit" class="submit-btn">저장</button>
            <a href="/board/list" class="cancel-btn">목록으로</a>
        </div>
    </form>
</main>

<%@ include file="../layout/footer.jsp" %>

</body>
</html>