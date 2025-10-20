package web2.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import web2.model.dto.UserDto;

@Mapper
public interface UserMapper {

    //1.회원 가입
    @Insert("insert into users(uid,upwd,uname,uphone,urole) values(#{uid},#{upwd},#{uname},#{uphone},#{urole})")
    @Options(useGeneratedKeys = true, keyProperty = "uno")
    public int sginup(UserDto userDto);

    // 2-1. 로그인
    //@Select("select * from users where uid = #{ uid } and upwd = #{ upwd }")
    //UserDto login( UserDto userDto );
    @Select("Select * from users where uid=#{uid}")
    UserDto login(String uid);

    // 3 : 패스워드를 제외한 아이디로 계정 정보 조회
    @Select("Select uno,uid,uname,uphone,urole from users where uid=#{uid}")
    UserDto myInfo(String uid);


}//inter end

