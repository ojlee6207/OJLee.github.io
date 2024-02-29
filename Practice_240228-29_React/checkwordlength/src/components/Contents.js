import '../css/common.css';

import React, { useState } from 'react';

export default function Contents() {
    const [word, setWord] = useState("");

    function changeWord(ev) {
        setWord(ev.target.value)
    }
    return(
        <>
            <div><h2 align="center">글자 수 체크 기능</h2>
                <hr></hr>
                <article id="textCheckBox">
                    <input type="text" id="textWriting" value={word} onChange={changeWord} />
                </article>
                <div id="numOfwords">
                    글자 수 : {word.length};
                </div>
            </div>
        </>
    )
}