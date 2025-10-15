package 실습.실습4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import 실습.실습4.model.dto.BookDto;
import 실습.실습4.model.mapper.BookMapper;

import java.awt.print.Book;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService{
    private final BookMapper bookMapper;

    public int bookWrite(BookDto bookDto){
        int result = bookMapper.bookWrite(bookDto);
        return result;
    }//func end

    public List<BookDto>bookSearch(String member,String title){
        List<BookDto> result = bookMapper.bookSearch(member,title);
        return result;
    }//func end

}//class end
