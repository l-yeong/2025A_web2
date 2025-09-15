package example.day06;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day06/batis")
@RequiredArgsConstructor
public class BatisController {
    private final BatisMapper batisMapper;

    //1. 학생 등록
    @PostMapping("")
    public ResponseEntity<Integer> save(@RequestBody StudentDto studentDto){
        int result = batisMapper.save(studentDto);
        return ResponseEntity.status(200).body(result);
    }//func end

    //2. 전체 조회
    @GetMapping("")
    public ResponseEntity<List<StudentDto>>findAll(){
        List<StudentDto> result = batisMapper.findAll();
        // ResponseEntity 응답객체
        return ResponseEntity.status(200).body(result);
    }//func end

    //3. 개별 조회
    @GetMapping("/find")
    public ResponseEntity<Map<String,Object>>find(@RequestParam int sno){
        Map<String,Object> result = batisMapper.find(sno);
        return ResponseEntity.status(200).body(result);
    }//func end

    //4. 개별 학생 삭제
    @DeleteMapping("")
    public ResponseEntity<Integer> delete(@RequestParam int sno){
        int result = batisMapper.delete(sno);
        return ResponseEntity.status(200).body(result);
    }//func end

    //5. 개별 학생 수정
    @PutMapping("")
    public ResponseEntity<Integer> update(@RequestBody StudentDto studentDto){
        int result = batisMapper.update(studentDto);
        return ResponseEntity.ok(result); // ok==200
    }//func end

}//class end1
