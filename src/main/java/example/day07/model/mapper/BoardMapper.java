package example.day07.model.mapper;

import example.day07.model.dto.BoardDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    //등록
    @Insert("INSERT INTO board(bcontent,bwriter)values(#{bcontent},#{bwriter})")
    public boolean boardWrite(BoardDto boardDto);

    //전체조회
    @Select("SELECT *FROM board;")
    public List<BoardDto>boardPrint();

    //개별조회
    @Select("SELECT *FROM board WHERE bno=#{bno}")
    public BoardDto boardFind(int bno);

    //수정
    @Update("UPDATE board set bcontent=#{bcontent} where bno=#{bno}")
    public boolean boardUpdate(BoardDto boardDto);

    //삭제
    @Delete("DELETE FROM board where bno=#{bno}")
    public boolean boardDelete(int bno);

}//class end
