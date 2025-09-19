package 실습.moive.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import 실습.moive.model.dto.ReviewDto;
import 실습.moive.model.mapper.ReviewMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewMapper reviewMapper;

    //등록
    public boolean reviewWrite(ReviewDto reviewDto){
        boolean result = reviewMapper.reviewWrite(reviewDto);
        return result;
    }//func end

    //전체조회
    public List<ReviewDto> reviewPrint(){
        List<ReviewDto> result = reviewMapper.reviewPrint();
        return result;
    }//func end

    //리뷰삭제
    public boolean reviewDelete(int rno, String inputPwd){
        String pwd = reviewMapper.reviewDelPwd(rno);
        if(pwd==null) return false;
        if(!pwd.equals(inputPwd)) return false;
        int result= reviewMapper.reviewDelete(rno);
        return result > 0;
    }

}
