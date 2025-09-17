package example.day07.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardDto {
    private int bno;
    private String bcontent;
    private String bwriter;
}
