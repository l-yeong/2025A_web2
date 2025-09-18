package example.day08.controller;

import example.day08.model.dto.TaskDto;
import example.day08.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/day08/task5")
@CrossOrigin(value="http://localhost:5173")
public class TaskController {
    private final TaskService taskService;

    //등록
    @PostMapping("")
    public ResponseEntity<Boolean> taskWrite(@RequestBody TaskDto taskDto){
        boolean result = taskService.taskWrite(taskDto);
        return ResponseEntity.status(200).body(result);
    }//func end

    //전체 조회
    @GetMapping("")
    public ResponseEntity<List<TaskDto>> taskPrint(){
        List<TaskDto> result = taskService.taskPrint();
        return ResponseEntity.ok(result);
    }//func end

    //삭제
    @DeleteMapping("")
    public ResponseEntity<Boolean> taskDelete(@RequestParam int tno){
        boolean result = taskService.taskDelete(tno);
        return ResponseEntity.status(201).body(result);
    }//func end

    //수정
    @PutMapping("")
    public ResponseEntity<Integer> taskUpdate(@RequestBody TaskDto taskDto){
        int result= taskService.taskUpdate(taskDto);
        return ResponseEntity.ok(result);
    }//func end

}//class end
