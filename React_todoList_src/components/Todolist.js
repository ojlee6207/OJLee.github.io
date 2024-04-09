import '/components/Todoitem'

export default function ToDoList() {
    const todos = [];
    return (
        <div className="ToDoList">
            { todos.map(todo => (
                <ToDoItem />
            ))}            
        </div>
    )
}