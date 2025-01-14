import React, {useState} from 'react';
import axios from 'axios';
import "./GptTest.scss";

function GptTest() {
    const [keyword, setKeyword] = useState("");
    const [recommendedSong, setRecommendedSong] = useState("");
    const [previousQuestion, setPreviousQuestion] = useState("");

    const inputQuestion = (e) => {
        setKeyword(e.target.value);
    };

    const getRecommendedSong = async() => {
        // recommendedSong.val("");
        
        try { 
            const response = await axios.post("https://api.openai.com/v1/chat/completions",
            {   model: "gpt-3.5-turbo", 
                messages: [{
                    "role" : "system",
                    "content" : "You're very nice jukebox for Rock'n Roll and Indie music." 
                }, {
                    "role" : "user",
                    "content" : keyword
                }, {
                    "role": "assistant",
                    "content": "Here are some music tracks related to the " + keyword
                    + ". So you must recommend a music when some users request a keyword about genre and music title."
                    + " And the track which you recommend is actually exists."                        
                    + " And if "+keyword+"is not related to the music, please re-question while user's request will be correctly."
                    + " If another question is requested, " + checkQuestion + " is needed to reply new question."
                    + " Also, please answer that which is from Korea, and your answer is replied by 한글"
                }],
                temperature : 0.5,
                max_tokens : 1024,
                top_p : 1,
                // frequency_penalty: -1.0,
                // presence_penalty: 0,
                // stop: ["stop"]
            },  
            {   headers: {
                "Content-Type": "application/json" ,
                Authorization: `Bearer ${import.meta.env.VITE_OPENAI_API_KEY}`
                },
            });
        // setRecommendedSong(response.data.recommendedSong);
        // const responseData = await response.json();
        // console.log(responseData);
            console.log(`${import.meta.env.VITE_OPENAI_API_KEY}`);
        // 응답에서 recommendedSong이 있는지 확인하고 그에 따라 설정합니다
            if (response.data && response.data.choices && response.data.choices.length > 0) {
                console.log(response);
                console.log(response.data);
                const recommendedSong = response.data.choices[0].message.content;
                setRecommendedSong(recommendedSong);

            } else {
                console.log(response);
                console.log(response.data);
                // recommendedSong이 없는 경우를 처리합니다
                setRecommendedSong("추천된 곡을 찾을 수 없습니다");
            }
        } catch (error) {
            console.error("Error fetching recommended song:", error);
        }

        setPreviousQuestion(keyword);

    }

    // 이전 질문 키워드 저장 및 참고할 함수
    const checkQuestion = (question) => {
        if(previousQuestion === question) {
            return "다른 답변을 드릴께요!! " + {recommendedSong};
        } else {
            return "Here are some music tracks related to the " + question + "...";
        }
    }
 
    return (
        <>
            <div className="modal">
                <input type="text" placeholder="Enter song Genre" 
                value={keyword} onChange={inputQuestion} />
                <button onClick={getRecommendedSong}>질문하기</button>
                {recommendedSong && (
                    <div className='divzzz'>
                        <p>Recommended Song은 다음과 같습니다 : {recommendedSong}</p>
                    </div>
                )}
            </div>
        </>

    )
}

export default GptTest;



/*
        const tools = [{
            "type":"function",
            "function": {
                "name": "get_musicTrack",
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
            }
        }];
        */