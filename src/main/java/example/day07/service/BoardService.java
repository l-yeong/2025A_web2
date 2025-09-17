package example.day07.service;

import example.day07.model.dto.BoardDto;
import example.day07.model.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    //등록
    public boolean boardWrite(BoardDto boardDto){
    boolean result = boardMapper.boardWrite(boardDto);
    return result;
    }//func end

    //전체 조회
    public List<BoardDto>boardPrint(){
        List<BoardDto> result = boardMapper.boardPrint();
        return result;
    }//func end

    //개별 조회
    public BoardDto boardFind(int bno){
        BoardDto result = boardMapper.boardFind(bno);
        return result;
    }//func end

    //수정
    public boolean boardUpdate(BoardDto boardDto){
        boolean result = boardMapper.boardUpdate(boardDto);
        return result;
    }//func end

    //삭제
    public boolean boardDelete(int bno){
        boolean result = boardMapper.boardDelete(bno);
        return result;
    }

}//class end
