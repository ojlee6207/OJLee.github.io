<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyBatis MyPage</title>
</head>
<body>
	<jsp:include page = "../common/menubar.jsp" />
		<div class="outer">
		<br><h1 align="center">MyPage</h1><br>
		<form action="update.me" method="post">
			<table align="center">
				<tr>
					<td>* 아이디</td>
					<td>
						<input type="text" name="userId" value="${ loginUser.userId }" readonly>
					</td>
				</tr>
				<tr>
					<td>* 패스워드</td>
					<td>
						<input type="password" name="userPwd" value="${ loginUser.userPwd }" required>
					</td>
				</tr>
				<tr>
					<td>* 이름</td>
					<td>
						<input type="text" name="userName" value="${ loginUser.userName }" readonly>
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;이메일</td>
					<td>
						<input type="email" name="email" value="${ loginUser.email }">
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;생년월일</td>
					<td>
						<input type="text" name="birthday" placeholder="yymmdd(6자리)" value="${ loginUser.birthday }">
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;성별</td>
					<td align="center">
						<input type="radio" name="gender" value="M" <c:if test="${ loginUser.gender eq 'M' }">checked</c:if>> 남
						<input type="radio" name="gender" value="F" <c:if test="${ loginUser.gender eq 'F' }">checked</c:if>> 여
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;연락처</td>
					<td>
						<input type="text" name="phone" placeholder="-포함" value="${ loginUser.phone }">
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;주소</td>
					<td>
						<input type="text" name="address" value="${ loginUser.phone }">
					</td>
				</tr>
			</table>
			<br>
			<div align="center">
				<button type="reset">초기화</button>
				<button type="submit">정보수정</button>
			</div>
		</form>
	</div>
	
</body>
</html>