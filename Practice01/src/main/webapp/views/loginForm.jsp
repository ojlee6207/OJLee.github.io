<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body { background-color: aqua;}

    .box {
        position:absolute;
        width:30%; height:50%;
        top:50%; left:50%;
        transform: translate(-50%, -50%);
        align-items: center;
    }
    h2 {
        color: rgb(230, 252, 255);
        text-shadow: 3px 3px darkblue;
        text-align: center;
    }
    #inputObject {
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        width : 100%;
    }
    #inputObject .inputbox {
        background-color: white;
        border-radius: 5px 5px 5px 5px;
        width : 80%;
        height: 50px;
    }
    .inputbox > input {
        margin-left : 4%;
        margin-top : 15px;
        border : 1px white none;
        width : 90%;
    }
    .inputbox > #subbutton {
        margin : 5%;
        border : 1px blue none;
        color : white;
        font-weight: bold;
    }

</style>
</head>
<body>
	<form action="/Practice01/login.do" method="POST" class="box">
		<h2>Happy day</h2>
        <div id="inputObject">
            <div class="inputbox"><input type="text" name="userId" placeholder="아이디"/></div><br>
            <div class="inputbox"><input type="password" name="userPwd" placeholder="비밀번호"/></div><br>
            <div class="inputbox"><button type="submit" name="submit" id="subbutton">로그인</button></div>
        </div>
	</form>
</body>
</html>