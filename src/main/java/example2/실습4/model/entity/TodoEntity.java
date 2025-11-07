package example2.실습4.model.entity;

import example2.실습4.model.basetime.BaseTime;
import example2.실습4.model.dto.TodoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="todo")
@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class TodoEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;

    // Entitiy -> Dto 변환
    public TodoDto todoDto(){
        return TodoDto.builder()
                .id(this.id)
                .title(this.title)
                .content(this.content)
                .build();
    }//func end


}//class end
