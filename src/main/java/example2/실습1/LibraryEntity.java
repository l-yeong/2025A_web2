package example2.실습1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class LibraryEntity {

    @Id //primary key
    private int bno;            // 도서 ID
    private String title;       // 도서명
    private String author;      // 저자명
    private String publisher;   // 출판사명

}//class end
