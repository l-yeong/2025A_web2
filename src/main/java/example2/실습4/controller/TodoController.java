package example2.실습4.controller;

import example2.실습4.model.dto.TodoDto;
import example2.실습4.service.TodoService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todo")

public class TodoController {
    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoDto todoDto){
        return ResponseEntity.ok(todoService.createTodo(todoDto));
    }//func end

    @GetMapping
    public ResponseEntity<?> getTodoList(){
        return ResponseEntity.ok(todoService.getTodoList());
    }//func end

}//class end
