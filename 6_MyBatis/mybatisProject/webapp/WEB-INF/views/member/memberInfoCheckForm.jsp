<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .checkdiv {
        display:flex;
    }
</style>
</head>
<body>
    <jsp:include page="../common/menubar.jsp" />
    <div class="outer">
        <form action="#" method="post">
            <div class="checkdiv" id="table1">
                <table>
                    <thead>
                        <tr>
                            <td colspan="2"><h3>아이디/비번찾기</h3></td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>이름</td>
                            <td><input id="name" /></td>
                        </tr>
                        <tr>
                            <td>생년월일</td>
                            <td><input id="birth" /></td>
                        </tr>
                        <tr>
                            <td>연락처</td>
                            <td><input id="phone" /></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="checkdiv" id="button1">
                <button type="submit">아이디/비번 찾기</button>
            </div>
        </form>
    </div>
</body>
</html>