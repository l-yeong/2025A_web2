package 실습.실습4.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import 실습.실습4.model.dto.BookDto;

import java.util.List;

@Mapper
public interface BookMapper {

    //등록
    int bookWrite(BookDto bookDto);

    //대출기록검색
    List<BookDto>bookSearch(String member, String title);

    //책일괄등록
    int bookAllWrite(List<BookDto>bookDto);



}//inter end
