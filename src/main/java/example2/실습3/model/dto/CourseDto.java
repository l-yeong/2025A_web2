package example2.실습3.model.dto;

import example2.실습3.model.entity.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder

public class CourseDto {

    private int courseId; // 과정번호
    private String courseName; //과정명
    private String createdAt;
    private String updatedAt;

    public CourseEntity toCourseEntity(){
        return CourseEntity.builder()
                .courseId(this.courseId)
                .courseName(this.courseName)
                .build();
    }

}//class end
