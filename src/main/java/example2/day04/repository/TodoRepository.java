package example2.day04.repository;

import example2.day04.entity.TodoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity,Integer> {
    // +++++ JPA Repository
    // 1. save() 2.findById() 3.findAll() 4.deleteById() 등등 미리 만드러진 CRUD 제공 한다.

    // 2. 쿼리메서드
    // * SQL 문장을 직접 작성하지 않고 메서드를 이름으로 쿼리 생성 < 카멜 표기법 >
    // 2-1 : findBy필드명 <---> select *from todo where = 매개변수
    List<TodoEntity> findByTitle(String title);  //findBy필드명(String title);
    // 2-2 : findBy필드명and필드명 <---> select *from todo where title = 매개변수 and content = 매개변수
    List<TodoEntity> findByTitleAndContent(String title, String content);
    // 2-3 : findBy필드명Containing <---> select *from where title like %매개변수%;
    List<TodoEntity> findByTitleContaining(String Keyword);
    // 2-5 : Pageable import org.springframework.data.domain.Pageable;
    Page<TodoEntity> findByTitleContaining(String keyword, Pageable pageable);

    // 3. 네이티브 쿼리 메서드
    // *SQL 뭄장을 직접 작성하여 실행 한다. ,: (콜론)매개변수 이용하여 매개변수 대입한다.
    // 3-1 : @Query(value="SQL작성",nativeQuery = true) 추상 메소드 주입한다.
    @Query(value = "select *from todo where title =:title",nativeQuery = true)
    List<TodoEntity>query1 (String title);
    // 3-2 :
    @Query(value = "select *from todo where title = :title and content = :content",nativeQuery = true)
    List<TodoEntity>query2 (String title,String content);
    // 3-3 :
    @Query(value = "select *from todo where title like %:keyword%",nativeQuery = true)
    List<TodoEntity>query3 (String keyword);
}//class end
