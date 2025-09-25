package 실습.실습3.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor@Data
public class BookDto {
    private int id;
    private String title;
    private int stock;
}//class end
