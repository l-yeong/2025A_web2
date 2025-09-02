package 실습.실습2;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class AlarmHandler extends TextWebSocketHandler {
    @Override
    //클라이언트 소켓이 서버소켓으로부터 연동 성공 실행되는 메소드
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("[서버] 클라이언트소켓과 연동 성공");
    }//func end

    @Override
    //클라이언트 소켓이 서버소켓으로부터 연동 실패 실행되는 메소드
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("[서버] 클라이언트소켓과 연동 실패");
    }//func end
}//class end
