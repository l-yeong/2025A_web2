package example2.실습3.model.entity;

import example2.실습3.model.basetime.BaseTime;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity @Data @Builder
@Table(name="courseentity")
public class CourseEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId; // 과정번호
    private String courseName; //과정명
}//class end
