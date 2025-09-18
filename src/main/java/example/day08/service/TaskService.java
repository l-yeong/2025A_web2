package example.day08.service;

import example.day08.model.dto.TaskDto;
import example.day08.model.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskMapper taskMapper;

    //등록
    public boolean taskWrite(TaskDto taskDto){
        boolean result = taskMapper.taskWrite(taskDto);
        return result;
    }//func end

    //전체조회
    public List<TaskDto> taskPrint(){
        List<TaskDto> result = taskMapper.taskPrint();
        return result;
    }//func end

    //삭제
    public boolean taskDelete(int tno){
        boolean result = taskMapper.taskDelete(tno);
        return result;
    }//func end

    //삭제
    public int taskUpdate(TaskDto taskDto){
        int result = taskMapper.taskUpdate(taskDto);
        return result;
    }//func end
}//class end
