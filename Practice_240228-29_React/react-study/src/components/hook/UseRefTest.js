/*
    useRef : 특정 어떤 DOM에 접근하거나,
            어떤 값(상태)의 변경을 렌더링 없이 저장할 때 사용되는 함수(hook)

    [1] import {useRef} from 'react';
    [2] const 변수명 = useRef();
        변수명 = {
            current: {//..}
        }
    [3] 특정 DOM에 접근하고자 할 때
        <태그 ref={변수명} />
*/
import React, { useState, useEffect, useRef } from 'react';

function UseRefTest() {
    const [id, setId] = useState("")
    const idRef = useRef();
    const idValRef = useRef();

    // 처음 렌더링 시점에 어떤 동작을 수행하고자 할 때
    useEffect(() => {
        // 아이디 입력창에 포커스를 주기
        idRef.current.focus();
    }, []);

    return (
        <div className="center">
            <input type="text" ref={idRef} placeholder="아이디" value={id}
                onChange={(e) => setId(e.target.value)} /><br />
            <input type="password" placeholder="비밀번호" /><br />
            <div>
                <button>로그인</button>
                <button onClick={() => (idValRef.current.value = id)}>입력값 확인</button>
            </div><br></br>
            <input type="text" ref={idValRef} placeholder='입력된 아이디 정보' />
            <br></br>
            <br></br>
            {/* location 객체... */}

            <button onClick={() => { window.location.reload() }}>새로고침</button>
            {/* <button onClick={()=>{window.location.href=window.location.href}}>새로고침</button> */}
        </div>
    )
}

export default UseRefTest;