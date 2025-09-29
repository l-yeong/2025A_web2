package 실습.실습3.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BookMapper {
    // 책 재고 차감
    @Update("update books set stock = stock-1 where id=#{bookid} and stock > 0")
    public int borrowBook(int bookid);

    //책 대여 기록
    @Insert("INSERT INTO rentals(book_id,member) values(#{bookid},#{member});")
    public int borrowBookLog(int bookid, String member);

    // 책 재고 증가
    @Update("update books set stock = stock +1 where id=#{bookid}")
    public int returnBook(int bookid);

    // 책 반납 기록
    @Insert("INSERT INTO rentals(book_id,member,return_date) values(#{bookid},#{member},now())")
    public int returnBookLog(int bookid, String member);
}//inter end
