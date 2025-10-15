package 실습.실습5.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import 실습.실습5.model.dto.BookDto;

import java.util.List;

@Mapper
public interface BookMapper {
    List<BookDto> bookAvg(BookDto bookDto);
}//inter end
