package 실습.실습3.service;

import example.day09.TransService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import 실습.실습3.model.dto.BookDto;
import 실습.실습3.model.mapper.BookMapper;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookMapper bookMapper;


    // CRUD 관심사 2개로 구현 해볼려고했더니 둘중 하나는 서비스에서 직접적으로 정보를 대입해야됌
    // 방법 2가지 (1) DTO 에 통합으로 Book,Log 정보 넣기 (2) MAP 사용
    // MAP 제일 가벼운것같아 선택
    @Transactional
    public boolean borrowBook(Map<String,Object>bookList){
        //대출
        // 1-1 책 재고 차감
        int stock = Integer.parseInt(String.valueOf(bookList.get("stock")));
        String title = String.valueOf(bookList.get("title"));
        boolean result1 = bookMapper.borrowBook(stock,title);

        // 1-2 만약에 책 재고 처리가 실패이면 롤백
        if(result1==false) throw new RuntimeException("[대여실패] 책 없음");

        // 2-1 책 대여 기록
        int book_id = Integer.parseInt(String.valueOf(bookList.get("book_id")));
        String member = String.valueOf(bookList.get("member"));
        boolean result2 = bookMapper.borrowBookLog(book_id,member);

        // 2-2 책 대여 기록 처리가 실패하면 롤백
        if(result2==false) throw new RuntimeException("[대여기록실패] 오류");

        return true;
    }//func end

    @Transactional
    public boolean returnBook(Map<String,Object>bookListReturn){
        //반납
        int stock = Integer.parseInt(String.valueOf(bookListReturn.get("stock")));
        String title = String.valueOf(bookListReturn.get("title"));
        boolean result1 = bookMapper.returnBook(stock,title);

        if(result1==false) throw new RuntimeException("[반납실패] 책 없음");

        //반납기록
        int book_id = Integer.parseInt(String.valueOf(bookListReturn.get("book_id")));
        String member = String.valueOf(bookListReturn.get("member"));
        boolean result2 = bookMapper.returnBookLog(book_id,member);

        if(result2==false) throw new RuntimeException("[반납기록실패] 오류");

        return true;
    }//func end

}//class end
