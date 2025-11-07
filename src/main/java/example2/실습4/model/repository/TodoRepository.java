package example2.실습4.model.repository;

import example2.실습4.model.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity,Integer> {
}//class end
