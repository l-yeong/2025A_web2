package example2.실습2;

import example2.day01.ExamEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/library")
public class LibraryController {

    private final LibraryService libraryService;

    //등록
    @PostMapping
    public ResponseEntity<?> bookPost(@RequestBody LibraryEntity libraryEntity){
        return ResponseEntity.ok(libraryService.bookPost(libraryEntity));
    }//func end

    //조회
    @GetMapping
    public ResponseEntity<?> bookGet(){
        return ResponseEntity.ok(libraryService.bookGet());
    }//func end

    //수정
    @PutMapping
    public ResponseEntity<?> bookUpdate(@RequestBody LibraryEntity libraryEntity){
        return ResponseEntity.ok(libraryService.bookUpdate(libraryEntity));
    }//func end

    //삭제
    @DeleteMapping
    public ResponseEntity<?> bookDelete(@RequestParam int bno){
        return ResponseEntity.ok(libraryService.bookDelete(bno));
    }//func end
}//class end
