import '../css/Login.css';

function Login() {
    function aElement(url, text) {
        return (
            <a href={"url"} style={{marginLeft:'5px', textDecoration:'none'}}>
                {text}</a>
        );
    }

    return(
        <>
            <img src="" alt="불러오기 실패" />
            <section>
                <article>
                    <input type="text" />
                    <input type="password" />    
                </article>
                <button>로그인</button>
            </section>
            {aElement("#","회원가입")}
            {aElement("#","아이디 찾기")}
            {aElement("#","비밀번호 찾기")}
            {/* <a href="#">회원가입</a>
            <a href="#">아이디찾기</a>
            <a href="#">비밀번호찾기</a> */}
        </>
    )
}

export default Login;