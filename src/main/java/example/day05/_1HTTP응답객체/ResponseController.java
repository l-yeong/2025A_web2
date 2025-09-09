package example.day05._1HTTP응답객체;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController     // HTTP 요청과 응답 처리 하는 어노테이션
@RequestMapping("/task/day05") // HTTP URL매핑(연결) 하는 어노테이션
public class ResponseController {
    // ============= HTTP 응답객체 ============= //
    // 1.
    @GetMapping("/bool")
    //public boolean task1(){}
    public ResponseEntity<Boolean>task1(){
        return ResponseEntity.status(401).body(false); //401 : 인증 실패 뜻
    }//func end

    @GetMapping("/int")
    public ResponseEntity<Integer>task2(){
        return ResponseEntity.status(202).body(1); // 202 : 요청 성공 했지만 처리 중 뜻
    }//func end

    @GetMapping("/string")
    public ResponseEntity<String>task3(){
        return ResponseEntity.status(201).body("test");
    }//func end

    @GetMapping("/void")
    public ResponseEntity<Void>task4(){
        return ResponseEntity.status(403).build(); // 403 : 접근 권한 없음 .build():반환값 없다
    }//func end

    @GetMapping("/object")
    public ResponseEntity<Map<String,String>>task5(){
        try{
//            Integer.parseInt("a");//예제] 강제로 예외발생
            Map<String,String>map = new HashMap<>(); // 예제 샘플
            map.put("data1","sample");
            return ResponseEntity.status(200).body(map);
        } catch (Exception e) {System.out.println(e);}//catch end
            return ResponseEntity.status(500).build(); // 500 : 서버 오류

    }

}//class end

/*
    boolean : 기본타입(8가지:byte, short, int, long, float, double, char, boolean)
    Boolean : 참조타입(기본타입외 : 클래스, [], 인터페이스)
        * 래퍼 클래스이란 : 기본타입을 참조타입으로 사용하는 클래스들 : int -> Integer
*/