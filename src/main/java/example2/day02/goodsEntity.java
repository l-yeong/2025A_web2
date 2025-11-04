package example2.day02;

import jakarta.persistence.*;
import lombok.*;

@Entity //해당 클래스를 데이터베이스 테이블과 매핑
@Table(name="goods") // 테이블 이름 정의, 생략시 클래스명으로 테이블명 정의
@Data @Builder @AllArgsConstructor @NoArgsConstructor

public class goodsEntity {

    @Id //PK 필드 주입 :: JPA는 엔티티 1개당 PK필드는 1개이상 필수 이다
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment 주입 :: MYSQL만 가능
    private int gno;        // 제품번호

    @Column(nullable = false,length = 100) //@Column(속성명=값,속성명=값),
    // null 제외, 글자수 100
    private String gname;   // 제품명

    @Column(nullable = true) // null 포함
    private int gprice;     // 제품가격

    @Column(columnDefinition = "varchar(100) default '제품설명' not null")
    private String gdesc;   // 제품설명

}//class end
