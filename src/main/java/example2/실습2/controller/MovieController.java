package example2.실습2.controller;

import example2.실습2.model.dto.MovieDto;
import example2.실습2.service.MovieService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movie")
public class MovieController {
    private final MovieService movieService;

    //등록
    @PostMapping
    public ResponseEntity<?> movieWrite(@RequestBody MovieDto movieDto){
        return ResponseEntity.ok(movieService.movieWrite(movieDto));
    }//func end

    //전체조회
    @GetMapping("/findall")
    public ResponseEntity<?> movieAll(){
        return ResponseEntity.ok(movieService.movieAll());
    }//func end

    //개별조회
    @GetMapping("/find")
    public ResponseEntity<?> movieFind(@RequestParam int movieid){
        return ResponseEntity.ok(movieService.movieFind(movieid));
    }//func end

    //삭제
    @DeleteMapping
    public ResponseEntity<?> movieDelete(@RequestParam int movieid){
        return ResponseEntity.ok(movieService.movieDelete(movieid));
    }//func end

    //수정
    @PutMapping
    public ResponseEntity<?> movieUpdate(@RequestBody MovieDto movieDto){
        return ResponseEntity.ok(movieService.movieUpdate(movieDto));
    }//func end

}//class end
