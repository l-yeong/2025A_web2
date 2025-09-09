package example.day05._2웹크롤링;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/task/day05")
@RequiredArgsConstructor // final 멤버변수의 생성자를 자동
public class CrawlingController {
    private final CrawlingService crawlingService;

    @GetMapping("/crawling")
    public Map<String,String> task1(){
        Map<String,String> map = new HashMap<>();

        return crawlingService.task1();
    }//func end

    @GetMapping("/crawling2")
    public List<String> task2(){
        return crawlingService.task2();
    }//func end
}//class end
