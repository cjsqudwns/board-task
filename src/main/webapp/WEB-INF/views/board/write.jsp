<%@ page contentType="text/html; charset=UTF-8" %>

<h2>게시글 작성</h2>
<form action="/board/write" method="post">
    제목: <input type="text" name="title"><br>
    내용: <textarea name="content" rows="5" cols="50"></textarea><br>
    <button type="submit">저장</button>
</form>
<a href="/board/list">목록으로</a>