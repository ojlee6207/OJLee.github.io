import React, {useState} from 'react';

function Counter() {
    // const num = 1;
    const [num, setNum] = useState(1);
    
    function addNumber() {
        setNum(num+1);
    }
    //---------------------------------
    const initValue="안녕";
    const [message, setMessage]= useState("안녕");
    
    function changeInputValue(event) {
        // 이벤트 객체 : event
        // 이벤트 객체가 가지고 있는 입력받은 값을 message 변수에 저장
        setMessage(event.target.value);
    }

    function reset() {
        setMessage(message);
    }
    
    // 사용자 입력을 받아 입력받은 값 표시, Reset 클릭시 다시 "안녕"이라 표시 되게 
    // -----------------------------
    const [like, setLike] = useState(false);

    function changeCheckValue(event) {
        // setLike(event.target.checked)
        setLike(!like);
    }

    const [names, setNames] = useState("이오재");
    const [age, setAge] = useState(24);

    function changeName(event) {
        setNames(event.target.value);
    }
    function addAge() {
        setAge(age+1);
    }

    return (
        <>
            {/* <button onClick={()=>{setNum(num+1)}}>클릭 시 증가(+1)</button> */}
            <button onClick={addNumber}>클릭 시 증가(+1)</button>
            <div>{num}</div>
            <hr></hr>
            <input type="text" value={message} onChange={changeInputValue} />
            <button onClick={()=>setMessage(initValue)}>Reset</button>
            <hr/>
            <input type='checkbox' checked={like} onChange={changeCheckValue}/>
            <label>좋아요</label>
            <p>
                {/* 체크가 된 상태면, 해당 게시글을 좋아합니다. */}
                {/* 체크가 해제된 상태면, 해당 게시글을 좋아하지 않습니다. */}
                {/* 조건 ? 참일떄 : 거짓일때 */}
                
                해당 게시글을 { like ? "좋아합니다." : "좋아하지 않습니다."}
            </p>
            <hr></hr>
            <input type="text" name="userName" value={names} onChange={changeName} />
            <button onClick={addAge}>나이 증가</button>
            <p>
                안녕하세요. { names } 님 당신은 { age }살입니다.
            </p>
        </>
    )
}

export default Counter;