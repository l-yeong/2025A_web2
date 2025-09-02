console.log("socket.js open")
// *** 클라이언트 웹 소켓 구현 ***
// 1. JS(클라이언트)가 SPRING(서버) 에게 웹소켓 접속/연결 요청
// new Websocket("ws:웹소켓서버주소"); //클라이언트 웹 소켓 객체 생성
// webSocketConfig 클래스 파일에서 정의한 주소를 확인
// new WebSocket("wg://localhost:8080/chat");
const client = new WebSocket("/chat");

//2. JS(클라이언트) 소켓 제공하는 주요 메소드들
//2-1 : onopen() : 서버소켓과 연결이 성공 되었을때
client.onopen = (event) => {
    console.log("[클라이언트] 서버소켓과 연동 성공");
}//func end

//2-2 : onclose() : 서버소켓과 연결이 종료 되었을때
client.onclose = (event) => {
    console.log("[클라이언트] 서버소켓과 연동 정료");
}//func end

//2-3 : onerror() : 서버 소켓과 에러가 발생 되었을때
client.onoerror = (event) => {
    console.log("[클라이언트] 서버소켓과 에러 발생");
}//func end

//2-4 : onmessage() : 서버 소켓으로부터 메시지를 받았을때
client.onmessage = (event) => {
    console.log("[클라이언트] 서버로부터 메시지 도착");

    console.log(event); //서버로부터 받은 이벤트 정보 객체
    console.log(event.data); //이벤트정보객체내 data 속성내  메시지가 들어있다.
    // 1)서버로부터 받은 메시지를 HTML 띄우기
    const msgBox = document.querySelector('.msgBox');
    let html= `<div>${event.data}</div>`
    msgBox.innerHTML += html;
}//func end


//2-5 : 전송 버튼을 클릭했을때 실행되는 메소드
const onSend =async() =>{
    // 1) 입력받은값 가져오기
    const msg = document.querySelector('.msg').value;
    // 2) 클라이언트소켓과 연결된 서버소켓에게 메시지
    client.send(msg);
}//func end