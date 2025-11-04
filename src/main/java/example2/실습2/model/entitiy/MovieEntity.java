package example2.실습2.model.entitiy;

import example2.실습2.model.basetime.BaseTime;
import example2.실습2.model.dto.MovieDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Movie")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class MovieEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private int movieid; //영화번호

    @Column( columnDefinition = "varchar(50) default '영화제목' not null " )
    private String title; // 영화제목

    @Column(nullable = false)
    private String director; //감독

    private String releaseDate; //개봉일
    private int rating; //평점

    //Entity --> Dto 변환
    public MovieDto toDto(){
        return MovieDto.builder()
                .movieid(this.movieid)
                .title(this.title)
                .director(this.director)
                .releaseDate(this.releaseDate)
                .rating(this.rating)
                .build();
    }//func end
}//class end
