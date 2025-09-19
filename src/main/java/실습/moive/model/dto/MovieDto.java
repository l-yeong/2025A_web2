package 실습.moive.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieDto {

    private int mno;
    private String mtitle;
    private String mname;
    private String mpwd;
    private String mgenre;
    private String mcontent;
}//class end
