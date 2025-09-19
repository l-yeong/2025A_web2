package 실습.moive.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import 실습.moive.model.dto.ReviewDto;
import 실습.moive.service.ReviewService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
@CrossOrigin(value="http://localhost:5173")
public class ReviewController {

    private final ReviewService reviewService;

    //등록
    @PostMapping("")
    public ResponseEntity<Boolean>reviewWrite(@RequestBody ReviewDto reviewDto){
        boolean result = reviewService.reviewWrite(reviewDto);
        return ResponseEntity.ok(result);
    }//func end

    //전체조회
    @GetMapping("")
    public ResponseEntity<List<ReviewDto>>reviewPrint(){
        List<ReviewDto> result = reviewService.reviewPrint();
        return ResponseEntity.ok(result);
    }//func end

    //개별삭제
    @DeleteMapping("")
    public ResponseEntity<Boolean>reviewDelete(@RequestParam int rno,@RequestParam String rpwd){
        boolean result = reviewService.reviewDelete(rno,rpwd);
        if(result){
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.status(400).body(result);
        }//if end
    }//func end

}//class end
