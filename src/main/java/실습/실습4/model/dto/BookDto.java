package 실습.실습4.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor@Data
public class BookDto {
    private int id;
    private String title;
    private int stock;
    private String member;
    private int book_id;
}//class end
