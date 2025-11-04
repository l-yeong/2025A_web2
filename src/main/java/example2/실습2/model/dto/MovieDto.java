package example2.실습2.model.dto;

import example2.실습2.model.entitiy.MovieEntity;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder

public class MovieDto {

    private int movieid; //영화번호
    private String title; // 영화제목
    private String director; //감독
    private String releaseDate; //개봉일
    private int rating; //평점
    private String createdAt;
    private String updatedAt;

    // DTO --> Entity 변환
    public MovieEntity toEntity(){
        return MovieEntity.builder()
                .movieid(this.movieid)
                .title(this.title)
                .director(this.director)
                .releaseDate(this.releaseDate)
                .rating(this.rating)
                .build();
    }//func end

}//class end
