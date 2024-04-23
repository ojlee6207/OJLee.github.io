import React, {useState} from 'react';
import axios from 'axios';
import "./GptTest.scss";

function GptTest() {
    const [keyword, setKeyword] = useState("");
    const [recommendedSong, setRecommendedSong] = useState("");

    const inputQuestion = (e) => {
        setKeyword(e.target.value);
    };

    const getRecommendedSong = async() => {
        
        try {
            const response = await axios.post('https://api.openai.com/v1/chat/completions', 
            { 
                headers: {
                    // "Content-type": "application/json",
                    Authorization : `${import.meta.env.VITE_OPENAI_API_KEY}`,    
                },
                body: JSON.stringify({
                    model: "gpt-3.5-turbo",
                    messages: [{
                        "role" : "you should recommend the song which other users"
                        + " find the genre of Rock'n roll or Indie music",
                        "content" : keyword
                    }]
                })
            });

            setRecommendedSong(response.data.recommendedSong);

        } catch (error) {
            console.log('Error recommended song', error);
        }
        /*
        const response = await fetch("https://api.openai.com/v1/chat/completions",
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json" ,
                Authorization: ''
            },
            body: JSON.stringify({
                model: "gpt-3.5-turbo", 
                messages: [{
                    "role" : "user",
                    "content" : keyword
                }]    
            })
        });
        setRecommendedSong(response.data.recommendedSong);
        */
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