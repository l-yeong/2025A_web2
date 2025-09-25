package 실습.실습3.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
    @Insert("update books set stock = stock - #{stock} where title=#{title}")
    public boolean borrowBook(int stock, String title);

    @Insert("INSERT INTO rentals(book_id,member) values(#{book_id},#{member});")
    public boolean borrowBookLog(int book_id, String member);

    @Insert("update books set stock = stock + #{stock} where title=#{title}")
    public boolean returnBook(int stock, String title);

    @Insert("INSERT INTO rentals(book_id,member,return_date) values(#{book_id},#{member},now())")
    public boolean returnBookLog(int book_id, String member);
}//inter end
