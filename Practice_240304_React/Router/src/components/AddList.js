import '../css/AddList.css';


export default function AddList() { 
    return (
        <>
            <div className="writeContent">
                <label>제목</label> 
                <input type="text" name="title" placeholder="내용을 입력해주세요" /><br></br>
                <label>내용</label>
                <textarea name="content" placeholder="내용을 입력해주세요" 
                    rows={10}></textarea><br></br>
                <button id="AddC" onClick="AddContent()">추가</button>
            </div>
        </>
    );
}