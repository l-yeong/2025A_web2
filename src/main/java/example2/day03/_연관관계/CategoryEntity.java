package example2.day03._연관관계;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Table(name="ecategory")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno;
    private String cname;
    //* 양방향 연결 *//
    // 상위 엔티티가 하위 엔티티 참조 관계
    @OneToMany(mappedBy = "categoryEntity") // 1:M, 하나 PK가 다수 FK에게
    // JPA 양방향 사용하고 DB 에서는 양방향 하지 않는다.
    @ToString.Exclude // 순환참조 방지
    @Builder.Default //빌더패턴 사용시 초기값 사용
    private List<BoardEntity> boardEntityList
            = new ArrayList<>();

}//class end
