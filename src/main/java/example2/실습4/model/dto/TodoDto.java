package example2.실습4.model.dto;

import example2.실습4.model.entity.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor@NoArgsConstructor@Builder
public class TodoDto {
    private int id;
    private String title;
    private String content;
    private String createdAt;
    private String updatedAt;

    //DTO -> Entity 변환
    public TodoEntity todoEntity(){
        return TodoEntity.builder()
                .id(this.id)
                .title(this.title)
                .content(this.content)
                .build();
    }//func end
}//class end
