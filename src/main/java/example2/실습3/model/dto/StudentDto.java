package example2.실습3.model.dto;

import example2.실습3.model.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class StudentDto {

    private int studentId;
    private int studentName;

    //DTO --> Entity 변환
    public StudentEntity toEntity(){
        return
    }

}//class end
