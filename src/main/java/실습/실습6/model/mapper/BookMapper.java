package 실습.실습6.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import 실습.실습6.model.dto.BookDto;

import java.util.List;

@Mapper
public interface BookMapper {

    boolean addRenTalLog();

    boolean addAvgStock();

    List<BookDto> rentalLogList();

    List<BookDto> addAvgStockList();
}//inter end
