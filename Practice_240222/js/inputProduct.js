function output1() {
    const area = document.getElementById("outputArea");

    area.innerHTML = "구매자명 : "+ customer.value+"님<br>";
    area.innerHTML += "상품명 : " + product.value+"<br>";
    area.innerHTML += "가격 : " + price.value+"만원<br>";
    if(amount >=10 && amount <=100) {
        area.innerHTML += "구매 수량 : " + amount.value+"개<br>";    
    } else {
        alert("수량 over 입니다.");
    }
    area.innerHTML += "납품등급 : " + level.value+"등급<br>";
    area.innerHTML += "기타사항: " + anything.value+"<br>";
}