import React, {useState} from 'react';
// import axios from 'axios';
import "../css/GptTest.css";

function GptTest() {
    const [keyword, setKeyword] = useState("");
    const [recommendedSong, setRecommendedSong] = useState("");

    const inputQuestion = (e) => {
        setKeyword(e.target.value);
    };

    const getRecommendedSong = async() => {
        

        const response = await fetch("https://api.openai.com/v1/chat/completions",
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json" ,
                Authorization: `Bearer ${process.env.REACT_APP_OPENAI_API_KEY}`
            },
            body: JSON.stringify({
                model: "gpt-3.5-turbo", 
                messages: [{
                    "role" : "user",
                    "content" : keyword,
                    "description": "Recommend song which is related to my keyword",
                    "parameters": {
                        "type": "object",
                        "properties": {
                            "song": {
                                "type": "string",
                                "description": "the song genre is related about rock'n roll or indie music"
                            },
                        },
                    "required": [
                    "song genre"
                    ]}
                }]    
            })
        });

        // setRecommendedSong(response.data.recommendedSong);
        const responseData = await response.json();

        // 응답에서 recommendedSong이 있는지 확인하고 그에 따라 설정합니다
        if (responseData && responseData.choices && responseData.choices.length > 0) {
            const recommendedSong = responseData.choices[0].message.content;
            setRecommendedSong(recommendedSong);

        } else {
            // recommendedSong이 없는 경우를 처리합니다
            setRecommendedSong("추천된 곡을 찾을 수 없습니다");

        }
    }

    


    return (
        <>
            <div className="modal">
                <input type="text" placeholder="Enter song Genre" 
                value={keyword} onChange={inputQuestion} />
                <button onClick={getRecommendedSong}>질문하기</button>
                {recommendedSong && (
                    <div>
                        <p>Recommended Song은 다음과 같습니다 : {recommendedSong}</p>
                    </div>
                )}
            </div>
        </>

    )
}

export default GptTest;