/*
    함수형 컴포넌트(Functional Component)
    - 클래스형 컴포넌트에 비해 비교적 간단
    - React v16.8 이후 Hook 기능 추가
        상태(State), 생명주기(life cycle) 관리가 가능하게 됨
*/
import React, { useState, useEffect } from 'react';
function FunctionalComponent() {
    const [sentence, setSentence] = useState('나는 함수형 입니다.');

    // useEffect : 렌더링 시점마다 실행되는 훅(Hook)
    // - 처음 한번만 실행하고자 할 경우 두번째 인자값으로 [] 작성

    useEffect(()=>{
        setSentence("나는 함수형 컴포넌트입니다.");
    }, [])

    return(
        <>
            <button onClick={()=>{setSentence("I'm functional.")}}>내용 바꾸기</button>
            <p>
                {sentence};
            </p>
        </>
    )
}

export default FunctionalComponent;