package 실습.moive.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import 실습.moive.model.dto.MovieDto;
import 실습.moive.service.MovieService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
@CrossOrigin(value="http://localhost:5173")
public class MovieController {
    private final MovieService movieService;

    //영화 등록
    @PostMapping("")
    public ResponseEntity<Boolean>movieWrite(@RequestBody MovieDto movieDto){
        boolean result = movieService.moveWrite(movieDto);
        return ResponseEntity.status(200).body(result);
    }//func end

    //영화전체조회
    @GetMapping
    public ResponseEntity<List<MovieDto>>moviePrint(MovieDto movieDto){
        List<MovieDto> result = movieService.moviePrint();
        return ResponseEntity.ok(result);
    }//func end

    //영화 삭제
    @DeleteMapping("")
    public ResponseEntity<Boolean>movieDelete(@RequestParam int mno, @RequestParam String mpwd){
        boolean result = movieService.movieDelete(mno,mpwd);
        System.out.println("mno = " + mno + ", mpwd = " + mpwd);
        if(result) {
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.status(400).body(result);
        }

    }//func end

}//class end
