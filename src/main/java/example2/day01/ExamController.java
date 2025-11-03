package example2.day01;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/exam")
public class ExamController {
    private final ExamService examService;

    // 1. 등록
    @PostMapping("")
    public ResponseEntity<?> post(@RequestBody ExamEntity examEntity){
        ExamEntity result = examService.post(examEntity);
        return ResponseEntity.ok(result);
    }//func end

    //2. 전체조회
    @GetMapping("")
    public ResponseEntity<?>get(){
        List<ExamEntity> result = examService.get();
        return ResponseEntity.ok(result);
    }//func end

    //3-1. 수정
    @PutMapping("/update")
    public ResponseEntity<?>put(@RequestBody ExamEntity examEntity){
        return ResponseEntity.ok(examService.put(examEntity));
    }//func end

    //3-2. 수정2
    @PutMapping("/update2")
    public ResponseEntity<?>put2(@RequestBody ExamEntity examEntity){
        return ResponseEntity.ok(examService.put2(examEntity));
    }//func end

    //4. 삭제
    @DeleteMapping("/update2")
    public ResponseEntity<?>delete(@RequestParam int col1){
        return ResponseEntity.ok(examService.delete(col1));
    }//func end

}//class end
