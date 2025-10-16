package 실습.실습5.controller;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import 실습.실습5.model.dto.BookDto;
import 실습.실습5.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor

public class BookController {
    private final BookService bookService;

    @PutMapping("/price")
    public ResponseEntity<Boolean>addPrice(){
        boolean result = bookService.addPrice();
        return ResponseEntity.ok(result);
    }//func end

    @PutMapping("/title")
    public ResponseEntity<Boolean>updateTitle(){
        boolean result = bookService.updateTitle();
        return ResponseEntity.ok(result);
    }//func end

    @GetMapping("/avg")
    public ResponseEntity<List<BookDto>>avgBook(){
        List<BookDto> result = bookService.avgBook();
        return ResponseEntity.ok(result);
    }//func end

    @GetMapping("/rental")
    public ResponseEntity<String>rentalBook(){
        String result = bookService.rentalBook();
        return ResponseEntity.ok(result);
    }

}//class end
