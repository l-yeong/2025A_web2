package example2.실습3.model.repository;

import example2.실습3.model.entity.EnrollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollRepository extends JpaRepository<EnrollEntity,Integer> {
}//class end
