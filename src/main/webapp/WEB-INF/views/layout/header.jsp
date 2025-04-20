<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<header>
    <div class="top-bar">
        <div class="left-links">
            <a href="#">Instagram</a>
            <a href="#">Facebook</a>
            <a href="#">Blog</a>
        </div>
        <div class="right-links">
            <%--            <c:if test="${empty sessionScope.userId}">--%>
            <%--                    <span style="font-size:12pt;"><input type="button" value="로그인"--%>
            <%--                                                         onclick="location.href='/login'"></span>--%>
            <%--            </c:if>--%>
            <%--            <c:if test="${not empty sessionScope.userId}">--%>
            <%--                <span>${sessionScope.userName} 님 </span>--%>
            <%--                <span style="font-size:12pt;"><input type="button" value="로그아웃"--%>
            <%--                                                     onclick="location.href='/logout'"></span>--%>
            <%--            </c:if>--%>
            <a href="#">Login</a>
            <a href="#">Mypage</a>
            <a href="#">Search</a>
        </div>
    </div>
    <h1 align="center">Simple Board</h1>
</header>
