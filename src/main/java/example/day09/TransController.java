package example.day09;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/day09/trans")
public class TransController {
    private final TransService transService;

    //1.
    @PostMapping("")
    public boolean trans1(){
        return transService.trans1();
    }

    //2.신동엽 이 서장훈 에게 10만원 보내는 예제, 신동엽 -빼기, 서장훈 +더하기
    @PostMapping("/transfer")
    public boolean transfer(@RequestBody Map<String,Object>transInfo){
        return transService.transfer(transInfo);
    }

}//class end
