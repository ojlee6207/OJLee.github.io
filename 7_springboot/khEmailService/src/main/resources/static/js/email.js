const sendEmail = () => {

    const receiver = document.querySelector("input[name=receiver]").value;
    const subject = document.querySelector("input[name=subject]").value;
    const content = document.querySelector("textarea[name=content]").value;
    const upfile = document.querySelector("input[name=upfile]").files[0];

    const formData = new FormData();
    formData.append("receiver", receiver);
    formData.append("subject", subject);
    formData.append("content", content);
    if(upfile) {
        formData.append("upfile", upfile);
    }
    const send_url = "sendMail.do"


    document.querySelector("#spinner").classList.remove("d-none");

    new asynConn().post(send_url, formData, (result) => {      // callback 함수 result
        
        document.querySelector("#spinner").classList.add("d-none");

        if(result === "success") {      // 이메일 전송 완료
            alert("전송 완료");
            receiver.value='';
            subject.value='';
            content.value='';
            upfile.value='';
        } else {        // 전송 실패
            alert("전송 실패");
        }
    })

}


class asynConn {
	constructor() {
		this.request = new XMLHttpRequest();
	}

	get(url, formData, callback) {

		this.#send("GET", url, formData, callback);
	}

	post(url, formData, callback) {

		this.#send("POST", url, formData, callback)
	}

	#send(type, url, formData, callback) {
		const req = this.request;
		req.open(type, url, true);
		
		req.onreadystatechange = (event) => {
			console.log(req.status, req.readyState);
			if (req.status == 200 && req.readyState == XMLHttpRequest.DONE) {
				callback(req.responseText);
			} else if (400 <= req.status && req.status < 600 ) {
				callback(req.responseText);
			}
		}

		req.send(formData);
	}
}