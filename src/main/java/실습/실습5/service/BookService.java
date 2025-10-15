package 실습.실습5.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import 실습.실습5.model.mapper.BookMapper;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookMapper bookMapper;

}//class end
