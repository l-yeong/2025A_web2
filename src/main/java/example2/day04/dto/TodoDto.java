package example2.day04.dto;

import example2.day04.entity.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@Builder@AllArgsConstructor@NoArgsConstructor
public class TodoDto {
    private int id;  // R U
    private String title; // C R U
    private String content; // C R U
    private boolean done; // C R U
    private String createDate; // R
    private String updateDate; // R

    // DTO -> Entity : C
    public TodoEntity toEntity(){
        return TodoEntity.builder()
                .title(this.title)
                .content(this.content)
                .done(this.done)
                .build();
    }//func end
}// class end
