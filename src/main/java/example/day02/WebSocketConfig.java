package example.day02;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

// ******** ws 프로토콜 통신이 왔을때 특정한 핸들러(클래스)로 매핑/연결 ********
@Configuration //스프링 컨테이너(메모리) 빈(객체) 등록
@EnableWebSocket // 웹소켓 사용 활성화
public class WebSocketConfig implements WebSocketConfigurer {
    // implements WebSocketConfigurer : 구현체

    @Autowired private ChatHandler chatHandler; // 서버웹소켓 객체


    // 1. 개발자가 만든 서버웹소켓(핸들러) 객체들을 스프링이 알수 있게 경로  ` 등록한다.
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
       // 내가(개발자) 만든 서버웹소켓(핸들러) 주소와 함께 등록 한다.
        //registry.addHandler(서버웹소켓객체,"경로")
        registry.addHandler(chatHandler,"/chat");
    }//func end
}//class end
