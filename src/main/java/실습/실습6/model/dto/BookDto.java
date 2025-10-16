package 실습.실습6.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor@Data
public class BookDto {
    private int id;
    private String title;
    private int stock;
    private String member;
}//class end
