package 실습.실습3.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
    // 책 재고 차감
    @Insert("update books set stock = stock - #{stock} where title=#{title} and stock > 0")
    public boolean borrowBook(int stock, String title);

    //책 대여 기록
    @Insert("INSERT INTO rentals(book_id,member) values(#{book_id},#{member});")
    public boolean borrowBookLog(int book_id, String member);

    // 책 재고 증가
    @Insert("update books set stock = stock + #{stock} where title=#{title}")
    public boolean returnBook(int stock, String title);

    // 책 반납 기록
    @Insert("INSERT INTO rentals(book_id,member,return_date) values(#{book_id},#{member},now())")
    public boolean returnBookLog(int book_id, String member);
}//inter end
