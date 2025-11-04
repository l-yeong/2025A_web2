package example2.실습2.service;

import example2.실습2.model.dto.MovieDto;
import example2.실습2.model.entitiy.MovieEntity;
import example2.실습2.model.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MovieService {
    private final MovieRepository movieRepository;

    //등록
    public MovieDto movieWrite(MovieDto movieDto){
        MovieEntity entity = movieDto.toEntity(); //저장할 dto 매개변수 받는다
        MovieEntity savedEntity = movieRepository.save(entity); // 엔티티 영속성

        if(savedEntity.getMovieid() >= 0){return savedEntity.toDto();} //만약에 pk가 생성되었으면 생성된 엔티티를 dto 변환 하여 반환
        return movieDto;
    }//func end

    //전체조회
    public List<MovieDto> movieAll(){
        List<MovieEntity> movieEntityList = movieRepository.findAll();
        List<MovieDto> movieDtoList = new ArrayList<>();

        for(int i=0; i<movieEntityList.size(); i++){
            MovieEntity entity = movieEntityList.get(i);
            movieDtoList.add(entity.toDto());
        }//for end
        return movieDtoList;
    }//func end

    //개별조회
    public MovieDto movieFind(int movieid){
        // 개별조회할 movieid 엔티티 조회
        Optional<MovieEntity> optional = movieRepository.findById(movieid);
        if(optional.isPresent()){ // 조회 결과 있으면
            MovieEntity entity = optional.get(); // 엔티티 꺼내기
            return entity.toDto(); //엔티티 dto 반환
        }//if end
        return null;
    }//func end

    //삭제
    public boolean movieDelete(int movieid){
        if(movieRepository.existsById(movieid)) { //pk값이 존재하면 true 없으면 false
            movieRepository.deleteById(movieid);
        }//if end
        return true;
    }//func end

    //수정
    public MovieDto movieUpdate(MovieDto movieDto){
        Optional<MovieEntity> optional = movieRepository.findById(movieDto.getMovieid());
        if(optional.isPresent()){
            MovieEntity entity = optional.get(); //영속화된 엔티티 꺼내기
            entity.setTitle(movieDto.getTitle());
            entity.setDirector(movieDto.getDirector());
            entity.setReleaseDate(movieDto.getReleaseDate());
            entity.setRating(movieDto.getRating());
            return entity.toDto(); //수정된 엔티티 dto로 변환 후 반환
        }//if end
        return movieDto;
    }//func end

}//class end
