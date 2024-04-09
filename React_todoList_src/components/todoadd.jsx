import '../css/todoadd.scss'

export default function ToDoAdd() {

    return (
        <div className="ToDoAdd">
            <input type="text" placeholder="ToDo 적기" />
            <button type="submit">등록하기</button>
        </div>
    )
}