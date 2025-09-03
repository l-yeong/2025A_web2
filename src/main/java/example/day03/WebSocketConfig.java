package example.day03;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration // 스프링 컨테이너(메모리)의 빈(객체)
@RequiredArgsConstructor
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    private final ChatSocketHandler chatSocketHandler;
    //내가 만든 서버 웹소켓 주소 등록 한다
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // registry.addHandler(웹소켓객체,매핑주소); : 여러개 등록 가능
        registry.addHandler(chatSocketHandler,"/chat");
    }//func end
}//class end
