package 실습.실습6.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import 실습.실습6.model.dto.BookDto;
import 실습.실습6.model.mapper.BookMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookMapper bookMapper;

    public boolean addRenTalLog(){
        boolean result = bookMapper.addRenTalLog();
        return result;
    }//func end

    public boolean addAvgStock(){
        boolean result = bookMapper.addAvgStock();
        return result;
    }//func end

    public List<BookDto>rentalLogList(){
        List<BookDto> result = bookMapper.rentalLogList();
        return result;
    }//func end

    public List<BookDto>addAvgStockList(){
        List<BookDto> result =bookMapper.addAvgStockList();
        return result;
    }//func end


}//class end
