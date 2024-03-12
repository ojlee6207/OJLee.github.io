<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignIn Happy Day</title>
<style>
	body { background-color: aqua;}
    .box {
        position:absolute;
        width:30%; height:50%;
        top:50%; left:50%;
        transform: translate(-50%, -50%);
        align-items: center;
    }
    table {
        width : 90%;
        color: rgb(0, 0, 0);
        font-weight: bold;
        font-size:18px;
    }

    h2 {
        color: rgb(230, 252, 255);
        text-shadow: 3px 3px darkblue;
        text-align: center;
    }
    .inputbox {
        background-color: white;
        border-radius: 10px 10px 10px 10px;
        width : 100%;
        height: 50px;

    }
    .inputbox > input {
        margin-top:5%; margin-left:4%;
        border : 1px white solid;
        width : 90%;
    }
    #signIn {
        background-color: greenyellow;
        width: 50%;
        font-size:24px; font-weight: bold;
        border-radius:10px;
    }
</style>
</head>
<body>
    <form action="/Practice01/singIn.do" method="POST" class="box">
		<h2>Happy day</h2>
        <table>
            <tr>
                <td>아이디</td>
                <td>&nbsp;&nbsp;</td>
                <td><div class="inputbox"><input type="text" name="userId" required/></div></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td>&nbsp;&nbsp;</td>
                <td><div class="inputbox"><input type="password" name="userPwd" required /></div></td>
            </tr>
            <tr>
                <td>비밀번호 확인</td>
                <td>&nbsp;&nbsp;</td>
                <td><div class="inputbox"><input type="password" name="userPwdChk" required /></div></td>
            </tr>
            <tr>
                <td>이름</td>
                <td>&nbsp;&nbsp;</td>
                <td><div class="inputbox"><input type="text" name="userName" /></div></td>
            </tr>
            <tr>
                <td>연락처</td>
                <td>&nbsp;&nbsp;</td>
                <td><div class="inputbox"><input type="text" name="phone" /></div></td>
            </tr>
        </table>
        <br>
        <div align="center">
            <button id="signIn" type="submit" onclick="">가입하기</button>
        </div>
	</form>
</body>
</html>