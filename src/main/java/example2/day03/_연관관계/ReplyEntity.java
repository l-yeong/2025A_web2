package example2.day03._연관관계;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "ereply")
@Data @NoArgsConstructor @AllArgsConstructor
public class ReplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rno;    // 댓글번호
    private String rcontent;    // 댓글낸용
    // 단방향 연결
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn( name = "bno") // FK 필드명
    private BoardEntity boardEntity;

}//class end

// 카테고리 <--- 게시물 <--- 댓글
