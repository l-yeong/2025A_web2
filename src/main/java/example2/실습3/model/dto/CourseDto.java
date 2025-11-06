package example2.실습3.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder

public class CourseDto {

    private int courseId; // 과정번호
    private String courseName; //과정명

}
