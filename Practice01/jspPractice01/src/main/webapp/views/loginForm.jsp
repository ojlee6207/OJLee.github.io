<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Happy Day Login</title>
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
        border-radius: 10px 10px 10px 10px;
        width : 80%;
        height: 50px;
        position : relative;
    }
    .inputbox > input {
        position : absolute;
        top:30%; left:4%;
        border : 1px white none;
        width : 90%;
    }
    #inputObject #subbutton {
        background-color: blue;
        border : 1px blue solid;

    }
    #subbutton > a {
        position : absolute;
        top: 22%; left:42%;
        text-align: center;
        text-decoration: none;
        color:white;
        font-size: 20px;
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
            <div class="inputbox" type="button" id="subbutton"><a href="">로그인</a></div>
        </div>
	</form>
</body>
</html>