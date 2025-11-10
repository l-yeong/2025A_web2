package example2.day04.entity;

import example2.day04.dto.TodoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // JPA 해당 엔티티를 테이블 매핑
@Table(name = "todo") // 테이블명 정의
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class TodoEntity extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;             //pk

    @Column(nullable = false, length = 100) // + 테이블 속성 옵션
    private String title;       //제목

    @Column(columnDefinition = "longtext") // + 테이블 속성 옵션
    private String content;     //내용

    @Column(columnDefinition = "boolean default false")
    private boolean done;       //실행(체크)여부

    //Entity -> DTO : R
    public TodoDto toDto(){
        return TodoDto.builder()
                .id(this.id)
                .title(this.title)
                .content(this.content)
                .done(this.done)
                .createDate(this.getCreateDate().toString())
                .updateDate(this.getUpdateDate().toString())
                .build();
    }//func end
}//class end
