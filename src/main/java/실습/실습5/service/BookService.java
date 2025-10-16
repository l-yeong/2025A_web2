package 실습.실습5.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import 실습.실습5.model.dto.BookDto;
import 실습.실습5.model.mapper.BookMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookMapper bookMapper;

    public boolean addPrice(){
        boolean result = bookMapper.addPrice();
        return result;
    }//func end

    public boolean updateTitle(){
        boolean result = bookMapper.updateTitle();
        return result;
    }//func end

    public List<BookDto>avgBook(){
        List<BookDto> result = bookMapper.avgBook();
        return result;
    }//func end

    public String rentalBook(){
        String result = bookMapper.rentalBook();
        return result;
    }

}//class end
