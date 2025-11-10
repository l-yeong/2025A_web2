package example2.day04.controller;

import example2.day04.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/todo")
@RequiredArgsConstructor
@RestController
public class TodoController {
    private final TodoService todoService;

    // [1] Repository 2-1, 3-1
    @GetMapping("/query1")
    public ResponseEntity<?>query1(@RequestParam String title){
        return ResponseEntity.ok(todoService.query1(title));
    }//func end

    // [2] Repository 2-2, 3-2
    @GetMapping("/query2")
    public ResponseEntity<?>query2(@RequestParam String title, @RequestParam String content) {
        return ResponseEntity.ok(todoService.query2(title, content));
    }//func end

    // [3] Repository 2-3, 3-3
    @GetMapping("/query3")
    public ResponseEntity<?>query3(@RequestParam String title){
        return ResponseEntity.ok(todoService.query3(title));
    }//func end

    // [4] 페이징처리
    @GetMapping("/page")
    public ResponseEntity<?> page1(@RequestParam(defaultValue = "1") int page,  // 조회할페이지번호
                                    @RequestParam(defaultValue = "3") int size){ // 조회 페이지에 조회할 자료의 총 개수
        return ResponseEntity.ok(todoService.page1(page,size));
    }//func end

    // [5] 검색페이징처리
    @GetMapping("/page2")
    public ResponseEntity<?> page2(@RequestParam String keyword,
                                   @RequestParam int page,
                                   @RequestParam int size){
        return ResponseEntity.ok((todoService.page2(keyword,page,size)));
    }
}//class end
