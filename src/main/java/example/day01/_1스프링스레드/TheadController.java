package example.day01._1스프링스레드;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task/day01")
@RequiredArgsConstructor
public class TheadController {
    private final ThreadService threadService;

    @GetMapping //동기화 : 스프링 매핑 컨트롤러는 자동 동기화 처리한다.
    // 먼저 요청을 한 HTTP 부터 처리후 반환 한다. // 요청 순서대로
    public int thead(){
        System.out.println("TheadController.thead");
        return threadService.thread1();
    }//fnc end

    @DeleteMapping
    public void thead2(){
        System.out.println("TheadController.thead2");
        threadService.thread2();
    }
}//clas end
