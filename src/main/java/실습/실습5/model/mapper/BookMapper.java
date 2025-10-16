package 실습.실습5.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import 실습.실습5.model.dto.BookDto;

import java.util.List;

@Mapper
public interface BookMapper {

    boolean addPrice ();

    boolean updateTitle();

    List<BookDto> avgBook();

    String rentalBook();
}//inter end
