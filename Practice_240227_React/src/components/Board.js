import React, { useState } from 'react';

import Square from './Square';

function Board() {
    const [index, setIndex] = useState(1); 

    function squareWithNum(num){
        return (
            <Square value={num} />
        )
    }
    // Square 컴포넌트를 사용
    // 함수 사용시에도 중괄호 {} 안에 작성
    // 시작태그와 종료태그 명시
    // <></> : 하나의 요소를 의미할 때 사용
    return (
        <>
            {squareWithNum(1)}
            {squareWithNum(2)}
            {squareWithNum(3)}
            <br></br>
            {squareWithNum(4)}
            {squareWithNum(5)}
            {squareWithNum(6)}
            <br/>
            {squareWithNum(7)}
            {squareWithNum(8)}
            {squareWithNum(9)}
        </>
    );
}

export default Board;