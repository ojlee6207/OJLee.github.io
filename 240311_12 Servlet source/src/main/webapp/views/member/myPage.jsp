<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Project</title>
<style>
	.outer {
		background:black;
		color:white;
		width:1000px;
		margin:auto;
	}

    /* margin:auto; => 가운데 정렬하고자 할 때 */
    #enroll-form table { margin : auto }
    #enroll-form input { margin : 5px }

</style>
</head>
<body>
	<h1>마이 페이지!</h1>
	<%@ include file="../common/menubar.jsp" %>
	<%
		String userId = loginUser.getUserId();
		String userName = loginUser.getUserName();
		String phone = loginUser.getPhone() == null ? "" : loginUser.getPhone();
		String email = loginUser.getEmail() == null ? "" : loginUser.getEmail();
		String address = loginUser.getAddress() == null ? "" : loginUser.getAddress();
		String interest = loginUser.getInterest() == null ? "" : loginUser.getInterest();
		
		// "운동, 요리"
		// String interest = String.join(",", loginUser.getInterest());
	%>
	<div class="outer">
		<br>
		<h2 align="center">회원가입</h2>
		<form action="<%= contextPath %>/update.me" id="enroll-form" method="post">
		<table>
			<tr>
				<td>* 아이디</td>
				<td><input type="text" name="userId" maxlength="12" value=<%= userId %> readonly></td>
			</tr>
			<tr>
				<td>* 이름</td>
				<td><input type="text" name="userName" maxlength="6" value=<%= userName %> required></td>
				<td></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" value=<%= phone %> placeholder="- 포함해서 입력"></td>
				<td></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="email" value=<%= email %> ></td>
				<td></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" value=<%= address %>></td>
				<td></td>
			</tr>
			<tr>
				<td>관심분야</td>
				<td colspan="2">
					<input type="checkbox" name="interest" id="sports" value="운동">
					<label for="sports">운동</label>
	
					<input type="checkbox" name="interest" id="climbing" value="등산">
					<label for="climbing">등산</label>
	
					<input type="checkbox" name="interest" id="fishing" value="낚시">
					<label for="fishing">낚시</label>
					<br>
					<input type="checkbox" name="interest" id="cooking" value="요리">
					<label for="cooking">요리</label>
	
					<input type="checkbox" name="interest" id="game" value="게임">
					<label for="game">게임</label>
	
					<input type="checkbox" name="interest" id="movie" value="영화">
					<label for="movie">영화</label>
				</td>
			</tr>
		</table>
		<script>
			const interest = "<%= interest %>"; // "운동, 요리", 유저 정보에 포함된 데이터
			// input 태그의 name 속성이 interest인 요소 배열
			const interestInput = document.querySelectorAll("input[name=interest]");
			
			for (let input of interestInput) {
				// 문자열A.includes(문자열B) => A에 B가 포함되어 있는지 여부
				if (interest.includes(input.value)) { // 유저 정보에 포함된 데이터에 해당 input요소의 value값이 포함되어 있다면
					input.checked = true;	// 해당 input요소(checkbox)를 체크된 상태로 변경
				}
			}
		</script>

		<br><br>

		<div align = "center">
			<button type="submit">정보변경</button>
			<button type="button">비밀번호변경</button>
			<button type="button">회원탈퇴</button>
		</div>
		<br><br>
		</form>
	</div>
</body>
</html>