package 실습.moive.model.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.DeleteMapping;
import 실습.moive.model.dto.ReviewDto;

import java.util.List;

@Mapper
public interface ReviewMapper {
    //등록
    @Insert("INSERT INTO moviereview(mno,rpwd,rcontent) VALUES(#{mno},#{rpwd},#{rcontent})")
    public boolean reviewWrite(ReviewDto reviewDto);

    //전체조회
    @Select("SELECT *FROM moviereview")
    public List<ReviewDto>reviewPrint();

    //리뷰삭제
    @Delete("DELETE FROM moviereview WHERE rno=#{rno}")
    public int reviewDelete(int rno);

    //리뷰삭제 비밀번호
    @Select("SELECT rpwd FROM moviereview WHERE rno=#{rno}")
    public String reviewDelPwd(int rno);
}//func end
