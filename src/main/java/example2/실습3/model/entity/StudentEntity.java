package example2.실습3.model.entity;

import example2.실습3.model.basetime.BaseTime;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name="studententity")
public class StudentEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String studentName;

}//class end
