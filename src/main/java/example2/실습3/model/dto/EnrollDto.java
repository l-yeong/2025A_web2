package example2.실습3.model.dto;

import example2.실습3.model.entity.EnrollEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class EnrollDto {

    private int enrollId; // 수강번호
    private String status; //수강상태
    private String createdAt;
    private String updatedAt;

    // DTO --> Entity
    public EnrollEntity toEnrollEntity(){
        return EnrollEntity.builder()
                .enrollId(this.enrollId)
                .status(this.status)
                .build();
    }
}
