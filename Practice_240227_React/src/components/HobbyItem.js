function HobbyItem({value, isChecked}) {
    return (
        <li>{value} {isChecked && 'v'}</li>
    )
}

export default HobbyItem;