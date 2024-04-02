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
<link rel="icon" href="data:;base64,iVBORw0KGgo=">

<body>
	<%@ include file="../common/menubar.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center">회원가입</h2>
		<form action="<%= contextPath %>/insert.me" id="enroll-form" method="post">
		<table>
			<tr>
				<td>* 아이디</td>
				<td><input type="text" name="userId" maxlength="12" required></td>
				<td><button type="button" onclick="checkUserId();">중복확인</button></td>
			</tr>
			<tr>
				<td>* 비밀번호</td>
				<td><input type="password" name="userPwd" maxlength="15" required></td>
				<td></td>
			</tr>
			<tr>
				<td>* 비밀번호 확인</td>
				<td><input type="password" name="userPwdCheck" maxlength="15" required></td>
				<td></td>
			</tr>
			<tr>
				<td>* 이름</td>
				<td><input type="text" name="userName" maxlength="6" required></td>
				<td></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" placeholder="- 포함해서 입력"></td>
				<td></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="email" ></td>
				<td></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" ></td>
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

		<br><br>

		<div align = "center">
			<button type="submit" onclick="return checkPwd();" disable>회원가입</button>
			<button type="reset">초기화</button>
		</div>

		<br><br>

		</form>
		<script>
			function checkUserId() {
				// 입력된 아이디 값 꺼내오기 (로그인 영역과 겹치므로 form 내의 input요소로 접근)
				const $userId = $("#enroll-form input[name=userId]");
			
				$.ajax({
					url: 'idCheck.me',
					type: 'get',
					data: { checkId: $userId.val() },		// 전달데이터의 키값 : checkId, 데이터값 : userId
					success: function(result) {		// 중복되는 값이 있을 때는 YYY, 없을때는 NNN
						// 중복되지 않은 경우, 사용자에게 "해당 아이디를 사용하시겠습니까?" 질문 후
						// 사용하는 경우 회원가입 활성화
						console.log(result);
						if (result === "NNN") {
							if(confirm("해당 아이디를 사용하시겠습니까?")) {
								$("#enroll-form :submit").removeAttr("disabled");	// disabled라는 속성 제거
								$userId.attr("readonly", true);					// readonly 속성을 true로
							} else {
								$userId.focus();
							}
						} else {		// 중복되는 아이디가 있으면
							alert("이미 존재하는 아이디거나 탈퇴한 회원의 아이디입니다. 다시 입려개주세요.");
							$userId.focus();
						}
					},
					error: function(err) {
						console.log("아이디 중복체크 통신 실패!");
						console.log(err);
					}
				})
			}
		
		
			function checkPwd() {
				// 비밀번호, 비밀번호 확인 요소 접근해서 값을 꺼내온 뒤
                let password = document.querySelector("#enroll-form input[name=userPwd]");
                let passwordcheck = document.querySelector("#enroll-form input[name=userPwdCheck]");

				// let password = document.getElementsByName("userPwd");
				// let passwordcheck = document.getElementsByName("userPwdCheck");

                // console.log(password)
                // console.log(passwordcheck)
				// 다른 경우 false를 리턴
				if (password.value != passwordcheck.value) {
					alert("비밀번호가 다릅니다. 확인 후 다시 입력해 주세요");
					return false;
				} else {
					return true;
				}
			}
		</script>
	</div>
</body>
</html>