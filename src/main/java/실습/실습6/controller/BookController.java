package 실습.실습6.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import 실습.실습6.model.dto.BookDto;
import 실습.실습6.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PutMapping("/rental")
    public ResponseEntity<Boolean>addRenTalLog(){
        boolean result = bookService.addRenTalLog();
        return ResponseEntity.ok(result);
    }//func end

    @PutMapping("/avg")
    public ResponseEntity<Boolean>addAvgStock(){
        boolean result = bookService.addAvgStock();
        return ResponseEntity.ok(result);
    }//func end

    @GetMapping("/rentalList")
    public ResponseEntity<List<BookDto>>rentalLogList(){
        List<BookDto> result = bookService.rentalLogList();
        return ResponseEntity.ok(result);
    }//func end

    @GetMapping("/avgList")
    public ResponseEntity<List<BookDto>>addAvgStockList(){
        List<BookDto> result = bookService.addAvgStockList();
        return ResponseEntity.ok(result);
    }//func end
}//class end
