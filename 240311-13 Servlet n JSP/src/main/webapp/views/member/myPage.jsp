<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Project</title>
<style>
.outer {
	background: black;
	color: white;
	width: 1000px;
	margin: auto;
}

/* margin:auto; => 가운데 정렬하고자 할 때 */
#enroll-form table {
	margin: auto
}

#enroll-form input {
	margin: 5px
}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>
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
		<form action="<%=contextPath%>/update.me" id="enroll-form"
			method="post">
			<table>
				<tr>
					<td>* 아이디</td>
					<td><input type="text" name="userId" maxlength="12"
						value=<%=userId%> readonly></td>
				</tr>
				<tr>
					<td>* 이름</td>
					<td><input type="text" name="userName" maxlength="6"
						value=<%=userName%> required></td>
					<td></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="phone" value=<%=phone%>
						placeholder="- 포함해서 입력"></td>
					<td></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" value=<%=email%>></td>
					<td></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" value=<%=address%>></td>
					<td></td>
				</tr>
				<tr>
					<td>관심분야</td>
					<td colspan="2"><input type="checkbox" name="interest"
						id="sports" value="운동"> <label for="sports">운동</label> <input
						type="checkbox" name="interest" id="climbing" value="등산">
						<label for="climbing">등산</label> <input type="checkbox"
						name="interest" id="fishing" value="낚시"> <label
						for="fishing">낚시</label> <br> <input type="checkbox"
						name="interest" id="cooking" value="요리"> <label
						for="cooking">요리</label> <input type="checkbox" name="interest"
						id="game" value="게임"> <label for="game">게임</label> <input
						type="checkbox" name="interest" id="movie" value="영화"> <label
						for="movie">영화</label></td>
				</tr>
			</table>
			<script>
			const interest = "<%=interest%>"; // "운동, 요리", 유저 정보에 포함된 데이터
			// input 태그의 name 속성이 interest인 요소 배열
			const interestInput = document.querySelectorAll("input[name=interest]");
			
			for (let input of interestInput) {
				// 문자열A.includes(문자열B) => A에 B가 포함되어 있는지 여부
				if (interest.includes(input.value)) { // 유저 정보에 포함된 데이터에 해당 input요소의 value값이 포함되어 있다면
					input.checked = true;	// 해당 input요소(checkbox)를 체크된 상태로 변경
				}
			}
		</script>
			<br>
			<br>

			<div align="center">
				<button type="submit" class="btn btn-primary">정보변경</button>
				<button type="button" class="btn btn-warning" data-bs-toggle="modal"
					data-bs-target="#changePwdModal">비밀번호변경</button>
				<button type="button" class="btn btn-danger" data-bs-toggle="modal"
					data-bs-target="#deleteMember">회원탈퇴</button>
			</div>
		</form>
	</div>
	<br>
	<br>
	<!-- 비밀번호 변경용 모달 -->
	<div class="modal fade" id="changePwdModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- 모달 헤더 부분 -->
				<div class="modal-header">
					<h1 class="modal-title fs-5">비밀번호 변경</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body" align="center">
					<form action="<%= contextPath %>/updatePwd.me" method="post">
						<!-- 아이디 정보 type='hidden' -->
						<input type="hidden" name="userId" value="<%=userId%>" />
						<!-- 현재 비밀번호/변경할 비밀번호/비밀번호 확인 -->
						<table>
							<tr>
								<td>현재 비밀번호</td>
								<td><input type="password" name="userPwd" required /></td>
							</tr>
							<tr>
								<td>변경할 비밀번호</td>
								<td><input type="password" name="updatePwd" required /></td>
							</tr>
							<tr>
								<td>변경할 비밀번호 확인</td>
								<td><input type="password" name="updatePwdCheck" required /></td>
							</tr>
						</table>
						<br>
						<button type="submit" id="edit-pwd-btn" class="btn btn-sm btn-warning">비밀번호
							변경</button>
					</form>
					<!-- 변경할 비밀번호와 변경할 비밀번호 확인 값이 동일한지 체크 -->
					<script>
						document.getElementById("edit-pwd-btn").onclick = function() {
							if ($("input[name=updatePwd]").val() !== 
								$("input[name=updatePwdCheck]").val()){
								alert("입력한 비밀번호의 값이 다릅니다.");
								return false; // 기존 이벤트를 동작하지 않도록 하기 위해 false 리턴
							}
						}
					</script>
				</div>
			</div>
		</div>
	</div>
	<!-- 회원 탈퇴 용 모달 창-->
	<!-- 비밀번호 변경용 모달 -->
	<div class="modal fade" id="deleteMember">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- 모달 헤더 부분 -->
				<div class="modal-header">
					<h1 class="modal-title fs-5">회원 탈퇴</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body" align="center">
					<form action="<%= contextPath %>/deleteMember.me" method="post">
						<b>
							탈퇴 후 복구가 불가능합니다.<br>
							정말로 탈퇴하시겠습니까?
						</b>
						<br>
						<!-- 아이디 정보 type='hidden' -->
						<input type="hidden" name="userId" value="<%=userId%>" />
						<!-- 현재 비밀번호/변경할 비밀번호/비밀번호 확인 -->
						<%-- 
							실행할 쿼리 : UPDATE MEMBER
										SET STATUS = 'N', MODIFY_DATE=SYSDATE
										WHERE USER_ID = ? AND USER_PWD =?
										1 : 로그인 아이디 2: 사용자 입력 비밀번호 
							* 회원 탈퇴임으로 변경 정보를 다시 재조회 필요 x 
							-> int (처리된 행 수) 기준으로 성공/실패 여부 판단
							
							- 성공 : 메인에서 alert("성공적으로 회원탈퇴, 그동안 감사");
									이 때 로그아웃 된 상태로(세션에서 정보 제거)
							- 실패 : 마이페이지에서 alert("실패") : 비밀번호 잘못 입력시
						--%>
						비밀번호 : <input type="password" name="userPwd" required /><br>

						<button type="submit" id="del-mem-btn" class="btn btn-sm btn-danger">회원탈퇴</button>
					</form>
		<!--		<script>
						document.getElementById("del-mem-btn").onclick = function() {
							if ($("input[name=userPwd]").val() !== 
								$(userPwd).val()){
								alert("입력한 비밀번호의 값이 다릅니다.");
								return false; // 기존 이벤트를 동작하지 않도록 하기 위해 false 리턴
							}
						}
					</script>  -->
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>