package 실습.실습3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import 실습.실습3.service.BookService;

import java.util.Map;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/rent")
    public boolean borrowBook(@RequestBody Map<String,Object>bookList){
        return bookService.borrowBook(bookList);
    }//func end

    @PostMapping("/return")
    public boolean returnBook(@RequestBody Map<String,Object>bookListReturn){
        return bookService.returnBook(bookListReturn);
    }
}//class end
