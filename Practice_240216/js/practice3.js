function idcheck() {
    let userId = document.getElementById("userId");
    let chkId = document.getElementById("chkId");

    if(userId.value == "user01") {
        console.log(userId.value);
        chkId.style.color = "red";
        chkId.innerHTML = "이미 존재하는 아이디 입니다.";
    } else {
        chkId.style.color = "green";
        chkId.innerHTML = "사용가능한 아이디 입니다.";
    }
}

function pwcheck() {
    let checkPw = document.getElementById("checkPw");
    let userPw = document.getElementById("userPw");
    let chkPw = document.getElementById("chkPw");

    if(checkPw.value == userPw.value) {
        chkPw.style.color = "green";
        chkPw.innerHTML = "비밀번호가 일치합니다..";
    } else {
        chkPw.style.color = "red";
        chkPw.innerHTML = "비밀번호가 일치하지 않습니다.";
    }
}

function checkUserInfo() {
    let chkId = document.getElementById("chkId");
    let chkPw = document.getElementById("chkPw");
    let userName = document.getElementById("name");

    if(chkId.style.color=="green" && chkPw.style.color=="green") {
        alert(userName.value+"님, 회원가입이 성공적으로 완료되었습니다^^");
    } else {
        alert("회원 가입 실패!");
    }
}