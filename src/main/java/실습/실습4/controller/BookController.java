package 실습.실습4.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import 실습.실습4.service.BookService;
import 실습.실습4.model.dto.BookDto;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    //등록
    @PostMapping("")
    public ResponseEntity<Integer> BookWrite(@RequestBody BookDto bookDto){
            int result = bookService.bookWrite(bookDto);
            return ResponseEntity.ok(result);
    } //func end
    //조회
    @GetMapping("")
    public ResponseEntity<List<BookDto>>bookSearch(@RequestParam String member,@RequestParam String title) {
        List<BookDto> result = bookService.bookSearch(member, title);
        return ResponseEntity.ok(result);
    }//func end
}//class end
