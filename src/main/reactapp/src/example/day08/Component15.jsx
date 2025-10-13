import axios from 'axios';
import { useRef } from 'react';

export default function Component(props) {

    //[1]
    const axios1 = async () => {
        try {
            const response = await axios.get("http://localhost:8080/axios");
            const data = response.data;
            console.log(data);
        } catch (e) { console.log(e) }//catch end
    }

    //[2] 로그인, axios.post{URL,BODY,OPTION}
    const axios2 = async () => {
        try {
            const obj = { id: "asd", pwd: "asd" }
            const option = { withCredentials: true };
            const response = await axios.post("http://localhost:8080/axios/login", obj, option)
            const data = response.data
            console.log("[2] :", data);
        } catch (e) { console.log(e) }//catch end
    }

    //[3] 정보확인, axios.get{url,option}
    const axios3 = async () => {
        try {
            const option = { withCredentials: true }
            const response = await axios.get("http://localhost:8080/axios/info", option)
            const data = response.data;
            console.log(data);
        } catch (e) { console.log(e) }

    }

    //fetch는 기본전송 타입이 'form',axios는 기본전송 타입이 'json'
    //[4] 일반 폼 : 폼전송시 자바의 변수명 매핑은 form 안에 name 속성으로 매핑
    const formRef1 = useRef();
    const axios4 = async () => {
        try {
            const form = formRef1.current; // 4-1 : useRef 참조중인 dom 객체 가져오기
            const option = { headers: { "Content-Type": "application/x-www-form-urlencoded" } }
            const response = await axios.post("http://localhost:8080/axios/form", form, option);
            const data = response.data;
            console.log('[4]:', data);
        } catch (e) { console.log(e) }//catch end
    }//func end

    //[5] 첨부파일 폼
    const formRef2 = useRef();
    const axios5 = async () => {
        try {
            const form = formRef2.current;
            const formData = new FormData(form); //폼 데이터를 바이너리(바이트) 폼 변환
            const option = { headers: { "Content-Type": "multipart/form-data" } }
            const response = await axios.post("http://localhost:8080/axios/formData", formData, option);
            const data = response.data;
            console.log(data);
        } catch (e) { console.log(e) }//catch end
    }//func end


    return (<>
        <h3>Component15(Axios)</h3>
        <button onClick={axios1}>Axios1</button>
        <button onClick={axios2}>Axios2</button>
        <button onClick={axios3}>Axios3</button>
        <h3>[4] 일반폼 </h3>
        <form ref={formRef1}>
            <input name="id" />
            <input name="pwd" />
            <button onClick={axios4} type="button">axios4</button>
        </form>

        <h3>[5] 첨부파일 폼</h3>
        <form ref={formRef2}>
            <input type="file" name="file" />
            <button onClick={axios5} type='button'>axios5</button>
        </form>
    </>)
}//func end