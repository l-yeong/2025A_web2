package example2.실습3.model.entity;

import example2.실습3.model.basetime.BaseTime;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name="enrollentity")
public class EnrollEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enrollId; // 수강번호
    private String status; //수강상태

    //Student 단방향 연결
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY) // M:1 다수FK가 하나 PK 에게
    @JoinColumn(name = "studentId")
    private StudentEntity studentEntity;

    //Enroll 단방향 연결
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY) // M:1 다수FK가 하나 PK 에게
    @JoinColumn(name = "courseId")
    private CourseEntity courseEntity;

}//class end
