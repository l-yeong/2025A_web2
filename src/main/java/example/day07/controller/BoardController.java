package example.day07.controller;

import example.day07.model.dto.BoardDto;
import example.day07.model.mapper.BoardMapper;
import example.day07.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    //등록
    @PostMapping("")
    public ResponseEntity<Boolean>boardWrite(@RequestBody BoardDto boardDto){
        boolean result = boardService.boardWrite(boardDto);
        return ResponseEntity.status(200).body(result);
    }//func end

    //전체조회
    @GetMapping("")
    public ResponseEntity<List<BoardDto>>boardPrint(){
        List<BoardDto> result = boardService.boardPrint();
        return ResponseEntity.status(201).body(result);
    }//func end

    //개별조회
    @GetMapping("/find")
    public ResponseEntity<BoardDto>boardFind(@RequestParam int bno){
        BoardDto result = boardService.boardFind(bno);
        return ResponseEntity.ok(result);
    }//func end

    //수정
    @PutMapping("")
    public ResponseEntity<Boolean>boardUpdate(@RequestBody BoardDto boardDto){
        boolean result = boardService.boardUpdate(boardDto);
        return ResponseEntity.ok(result);
    }//func end
    //삭제
    @DeleteMapping("")
    public ResponseEntity<Boolean>boardDelete(@RequestParam int bno){
        boolean result = boardService.boardDelete(bno);
        return ResponseEntity.status(201).body(result);
    }//func end


}//class end
