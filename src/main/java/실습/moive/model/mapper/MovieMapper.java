package 실습.moive.model.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import 실습.moive.model.dto.MovieDto;

import java.util.List;


@Mapper

public interface MovieMapper {
    //영화등록
    @Insert("INSERT INTO movie(mtitle,mname,mpwd,mgenre,mcontent)" +
            "values(#{mtitle},#{mname},#{mpwd},#{mgenre},#{mcontent})")
    public boolean moveWrite(MovieDto movieDto);
    //영화전체조회
    @Select("SELECT *FROM movie;")
    public List<MovieDto>moviePrint();

    //영화삭제
    @Delete("DELETE FROM movie WHERE mno=#{mno}")
    public int movieDelete(int mno);

    //영화삭제 비밀번호
    @Select("SELECT mpwd FROM movie WHERE mno=#{mno}")
    public String movieDelPwd(int mno);

}
