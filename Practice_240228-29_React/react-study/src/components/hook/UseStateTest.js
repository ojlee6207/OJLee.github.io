/*
    훅 (Hook)
    : (함수형) 컴포넌트에서 사용
    상태(state)와 생명주기(life cycle)기능을 사용할 수 있도록 해주는 함수

    - useState : 상태를 관리할 수 있도록 해주는 함수 (생성, 변경)
    [1] import React, { useState } from 'react';
    [2] 생성
        const [변수명, 함수명] = useState([초기값]);
        - 변수명: 현재 상태의 데이터를 저장하는 공간(이름)
        - 함수명: 해당 상태의 데이터를 변경하는 함수(이름)
    [3] 사용
        현재 상태의 데이터를 사용하고자 하면? 변수명
        * HTML내 사용시 : {변수명}
        * script 내 사용 시 : 변수명
        해당 상태의 데이터를 변경하고자 하면? 함수명(변경할 값)
*/
import React, {useState} from 'react';
export default function UseStateTest() { 
    const [num, setNum] = useState(1);
    const [num2, setNum2] = useState(0);

    function addNumber() {
        setNum(num+num2);
    }

    function reduceNumber() {
        setNum(num-num2);
    }

    function changeNum(event) {
        setNum2(Number(event.target.value))
    }

    return(
        <>
            <div>
                <button className="w-85" onClick={addNumber}>+</button>
                {/* onClick={()=>setNum(num+1)} */}
                <button className="w-85" onClick={reduceNumber}>-</button>
            </div>
            <input type="text" value={num} /><br></br>
            <input type="text" defaultValue={num2} onChange={changeNum} />
            {/* onchange */}
        </>
    );
}