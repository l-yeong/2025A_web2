package example.day08.model.mapper;

import example.day08.model.dto.TaskDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {

    //등록
    @Insert("INSERT INTO task5(tname,tphone,tage)values(#{tname},#{tphone},#{tage})")
    public boolean taskWrite(TaskDto taskDto);

    //전체조회
    @Select("SELECT *FROM task5;")
    public List<TaskDto>taskPrint();

    //삭제
    @Delete("DELETE FROM task5 WHERE tno=#{tno}")
    public boolean taskDelete(int tno);

    //수정
    @Update("UPDATE task5 SET tname=#{tname},tphone=#{tphone},tage=#{tage} WHERE tno=#{tno}")
    public int taskUpdate(TaskDto taskDto);
}//class end
