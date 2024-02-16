function changeTotal() {
    let totalchk = document.getElementById("total");
    console.log(totalchk.checked); 

    let allCheckBox = document.getElementsByName("readbook");
    for(let checkbox of allCheckBox){
        checkbox.checked = totalchk.checked;
    }
}

function checkBoxTrigger() {
    let allChecked = true;
    let booklist = document.getElementsByName("readbook");
    for(let readbook of booklist) {
        // 체크 박스 중 체크 해제가 된 경우
        if (!readbook.checked) {
            // allChecked 변수의 값을 false로 변경
            allChecked = false;
        }
    }
    let totalChk = document.getElementById("total");
    totalChk.checked = allChecked;    
}

function selCategory() {
    
    let category = document.getElementById("category");
    let arr = [];
    let arrBook = document.getElementsByName("readbook");

    for(let i=0; i<arrBook.length; i++) {
        if(arrBook[i].checked) {
            arr.push(arrBook[i].value);
        } else {
            continue;
        }
    }
    category.innerHTML = '';

    category.innerHTML += arr.join(" ");


}