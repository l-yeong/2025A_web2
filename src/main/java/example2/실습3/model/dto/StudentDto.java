package example2.실습3.model.dto;

import example2.실습3.model.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class StudentDto {

    private int studentId;
    private String studentName;
    private String createdAt;
    private String updatedAt;

    //DTO --> Entity 변환
    public StudentEntity toStudentEntity(){
        return StudentEntity.builder()
                .studentId(this.studentId)
                .studentName(this.studentName)
                .build();
    }

}//class end
