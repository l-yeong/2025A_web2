package 실습.moive.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import 실습.moive.model.dto.MovieDto;
import 실습.moive.model.mapper.MovieMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieMapper movieMapper;


    //영화 등록
    public boolean moveWrite(MovieDto movieDto){
        boolean result = movieMapper.moveWrite(movieDto);
        return result;
    }//func end

    //영화 전체 조회
    public List<MovieDto> moviePrint(){
        List<MovieDto> result = movieMapper.moviePrint();
        return result;
    }//func end

    //영화 삭제
    public boolean movieDelete(int mno, String inputPwd){
        String pwd=movieMapper.movieDelPwd(mno);
        if(pwd==null) return false;
        if(!pwd.equals(inputPwd)) return false;
        int result = movieMapper.movieDelete(mno);
        return result > 0;
    }//func end

}//class end
