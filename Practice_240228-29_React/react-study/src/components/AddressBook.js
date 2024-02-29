import { useState, useRef} from "react";
import { Button, Table, Form } from "react-bootstrap";
import AddressList from "./AddressList"

export default function AddressBook() {
    const [num, setNum] = useState(1);

    const [keyword, setKeyword] = useState("");
    const addrList = [
        {no:1, name:"홍길동", phone:"010-1111-1111"},
        {no:2, name:"아무개", phone:"010-2222-2222"},
    ] 

    const optRef = useRef();
    const checkRef = useRef();

    function BrowseKeyword () {
        // select 태그(요소)의 선택된 항목(option)의 value 값
        // console.log(document.querySelector("select").value);
        // console.log(optRef.current.value);
        const option = optRef.current.value;
        // option => name, 입력값: 홍길동... 연락처 출력
        addrList.forEach(function(address){
            // address 객체 안에 option =>"name"이라는 속성 값
            if(option in address &&
                address[option] === keyword) {
                console.log(`${address.name}의 연락처는 ${address.phone}`);
                return;
            }
        });
        // 결과가 있으면 해당 내용 출력(콘솔, alert...)
    }

    return (
        <>
            <div>
                <Form.Select ref={optRef} size="sm">
                    <option value={"name"}>이름</option>
                    <option value={"phone"}>연락처</option>
                </Form.Select>
                &nbsp;
                <Form.Control type="text" value={keyword} 
                    onChange={(e)=>setKeyword(e.target.value)}
                    placeholder="검색어를 입력하세요" />
                &nbsp;
                {/* <button onClick={BrowseKeyword}>검색</button> */}
                <Button variant="info" onClick={BrowseKeyword}>검색</Button>
            </div>
            <br></br>
            <Table bordered hover striped variant="dark">
                <colgroup>
                    <col></col>
                    <col width={"40%"}></col>
                    <col width={"50%"}></col>
                </colgroup>
                <thead>
                    <tr>
                        <th>No</th>
                        <th>이름</th>
                        <th>연락처</th>
                    </tr>
                </thead>
                <tbody>
                    { 
                        addrList.map(function(address){
                            return (
                                <AddressList key={address.no}
                                             no={address.no} 
                                             name={address.name} 
                                             phone={address.phone} />
                            )
                    })}
                    {/* <tr>
                        <td>1</td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td></td>
                        <td></td>
                    </tr> */}
                </tbody>
            </Table>
            <div>
                <input type="text" placeholder='이름' value={AddressList.name} />
                <input type="text" placeholder='연락처' value={AddressList.phone} />
                <Button variant="outline-secondary" onClick={()=>(setNum+1)}>추가</Button>
            </div>
        </>
    )
}