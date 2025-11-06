package example2.실습3.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class EnrollDto {

    private int enrollId; // 수강번호
    private String status; //수강상태

}
