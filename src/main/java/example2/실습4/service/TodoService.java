package example2.실습4.service;

import example2.실습4.model.dto.TodoDto;
import example2.실습4.model.entity.TodoEntity;
import example2.실습4.model.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {
    private final TodoRepository todoRepository;
    //등록
    public TodoDto createTodo(TodoDto todoDto){
        TodoEntity entity = todoDto.todoEntity(); // 저정할 dto 매개변수 받음
        TodoEntity saveEntity = todoRepository.save(entity); // 엔티티 영속성

        if(saveEntity.getId() >= 0){return saveEntity.todoDto();} //만약에 pk가 생성되어있으면 생성된 엔티티를 dto 변환 하여 반환
       return todoDto;
    }//func end

    //조회
    public List<TodoDto> getTodoList(){
        List<TodoEntity> todoList = todoRepository.findAll();
        List<TodoDto> todoDtoList = new ArrayList<>();

        for(int i=0; i<todoList.size(); i++){
            TodoEntity entity = todoList.get(i);
            todoDtoList.add(entity.todoDto());
        }//for end
        return todoDtoList;
    }//func end

}//class end
