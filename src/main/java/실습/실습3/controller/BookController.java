package 실습.실습3.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import 실습.실습3.service.BookService;

import java.util.Map;


@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
@Log4j2 // 로그(기록) 처리하는 어노테이션 제공
public class BookController {
    private final BookService bookService;

    // 2. print 함수 대신에 로그함수 사용해보기 = 부가기능 제공, 제약 조건 등
    @GetMapping("/log")
    public void log(){
        System.out.println("개발단계에서는 print 정말 많이 작성하자...");
        //log.XXX : 출력함수 처럼 출력하는 메시지 함수 이면서 부가기능(파일처리/제약조건)
        log.debug("테스트 과정 사용된다.");      // 테스트(개발)과정 에서 메시지
        log.info("서비스의 흐름/상태 사용된다");  // 운용과정 메시지
        log.warn("잠재적 문제 사용된다.");       // 유지보수 과정 메시지
        log.error("예외/실패 상황 사용된다.");    // 운용/유지보수 과정 메시지
    }//func end


    @PostMapping("/rent")
    public ResponseEntity<Boolean> borrowBook(@RequestBody Map<String,Object>bookList){
        boolean result = false;
        try{
            result = bookService.borrowBook(bookList);
            log.debug("[대여성공]"+bookList);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            log.debug("[대여실패]"+bookList+e.getMessage()); //만약에 롤백이면 e.getMessage():예외메시지
            return ResponseEntity.status(400).body(result);
        }

    }//func end

    @PostMapping("/return")
    public ResponseEntity<Boolean> returnBook(@RequestBody Map<String,Object>bookListReturn){
        boolean result = false;
        try{
            result = bookService.returnBook(bookListReturn);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.status(405).body(result);
        }
    }
}//class end
