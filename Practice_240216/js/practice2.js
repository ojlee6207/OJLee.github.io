function calculation() {
    let sign = document.getElementById("select-box").value;
    console.log(sign);
    let num1 = document.getElementById("inputNum1").value;
    let num2 = document.getElementById("inputNum2").value;
    // let calresult = document.getElementById("result").value;

    console.log(num1);
    console.log(num2);
    document.getElementById("result").style.background="white";
    document.getElementById("result").style.color="black";

    if(sign == "plus") {
        document.getElementById("result").value = parseFloat(num1)+parseFloat(num2);
        console.log(document.getElementById("result").value);
        // calresult = parseFloat(num1)+parseFloat(num2);
    } else if(sign == "minus") {
        document.getElementById("result").value = parseFloat(num1)-parseFloat(num2);
        console.log(document.getElementById("result").value);
    } else if(sign == "times") {
        document.getElementById("result").value = parseFloat(num1)*parseFloat(num2);
        console.log(document.getElementById("result").value);
    } else if(sign == "divide") {
        document.getElementById("result").value = parseFloat(num1)/parseFloat(num2);
        console.log(document.getElementById("result").value);
        if (document.getElementById("result").value == "Infinity") {
            document.getElementById("result").style.background="red";
            document.getElementById("result").style.color="white";
            document.getElementById("result").value="연산불가";
        }
    } else if(sign == "sulplus") {
        document.getElementById("result").value = parseFloat(num1)%parseFloat(num2);
        console.log(document.getElementById("result").value);
        if (document.getElementById("result").value == "NaN") {
            document.getElementById("result").style.background="red";
            document.getElementById("result").style.color="white";
            document.getElementById("result").value="연산불가";
        }
    }
    num1 = '';
    num2 = '';
    sign = '';
}