<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.member.model.vo.Member"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	// login 시도 전 loginUser 객체가 null
	System.out.println("=================");
	System.out.println(loginUser);
	System.out.println("=================");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Project</title>
<style>
    .login-area > * {
        float:right;
    }

    .login-area a {
        text-decoration: none;
        color:black;
        font-size: 12px;
    }
</style>
</head>
<body>
    <h1 align="center">Welcome OhJae World</h1>

    <div class="login-area">
        <% if(loginUser==null) { %>
        <!-- 1) 로그인 전 -->
        <form action="/jsp/login.me" method="post">
            <table>
                <tr>
                    <th>아이디</th>
                    <td><input type="text" name="userId" required /></td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td><input type="password" name="userPwd" required /></td>
                </tr>
                <tr>
                    <th colspan="2">
                        <button type="submit">로그인</button>
                        <button type="">회원가입</button>
                    </th>
                </tr>
            </table>
        </form>
		<% } else { %>
        <!-- 2) 로그인 후 -->
        <br><br>
        <div align="center">
            <b><%= loginUser.getUserName() %></b>님의 방문을 환영합니다.
            <br><br>
            <a href="">마이페이지</a>
            <a href="/jsp/logout.me">로그아웃</a>
        </div>
    </div>
    <% } %>
</body>
</html>