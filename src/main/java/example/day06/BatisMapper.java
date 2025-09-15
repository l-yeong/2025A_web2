package example.day06;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface BatisMapper {

    //1. 학생 등록
    @Insert("INSERT INTO student(name,kor,math) values(#{name},#{kor},#{math})")
    int save(StudentDto studentDto); // 추상메소드
    //int : insert 된 레코드 수 반환 1:성공, 0:실패

    //2. 전체 조회
    @Select("Select *from student")
    List<StudentDto>findAll();
    //3. 개별 조회
    @Select("select *from student where sno = #{sno}")
    Map<String,Object>find(int sno);

    //4. 개별 학생 삭제
    @Delete("delete from student where sno = #{sno}")
    int delete(int sno);

    //5. 개별 학생 수정
    @Update("update student set kor = #{kor}, math = #{math} where sno = #{sno}")
    int update(StudentDto studentDto);

}//face end

