package example.day04._1빌더패턴;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.lang.reflect.Member;

//(2) 설계 클래스
@Builder // **빌더 패턴**
@ToString
class MemberDto{

    // 1. 멤버변수 : (메모리) 객체의 속성
    private String name;
    private int age;

    // 2. 생성자 : (초기화) 객체를 생성할때 사용되는 *초기화* 메소드
    public MemberDto() {}                       //2-1 기본 생성자 : 매개변수 없는
    public MemberDto(String name,int age) {     //2-2 전체 생성자 : 모든 매개변수를 갖는
        this.name=name;
        this.age=age;
    }

    // 3. 메소드 : (함수) 객체의 행동/이벤트/함수


}//class end

// (1) 실행 클래스
public class Example1 {
    public static void main(String[] args) {
        // 1. 객체를 생성할때 사용되는 메소드 : new 연산자 뒤로 new MemberDto()
        MemberDto m1 = new MemberDto();
        // 2.
        MemberDto m2 = new MemberDto("유재석",40);
        // 3. ************ 생성자의 규칙 ************
        // 3-1 존재 하지 않는 생성자는 불가능
        // MemberDto m3 = new MemberDto("유재석");

        // 3-2 매개변수의 순서를 바꾸면 안된다.
        // MemberDto m4 = new MemberDto(40,"유재석");

        // 즉: 생성자는 정해진 매개변수에 따라 사용된다. 유연성이 떨어짐.

        // 4. ************ 롬복의 빌더 패턴 ************
        // 즉] 생성자 유무와 상관없이 메소드를 객체 초기화
        MemberDto m5 = MemberDto.builder().build();
        System.out.println("m5 = " + m5);
        
        MemberDto m6 = MemberDto.builder().name("유재석").build();
        System.out.println("m6 = " + m6);
        
        MemberDto m7 = MemberDto.builder().age(40).name("유재석").build();
        System.out.println("m7 = " + m7);

    }//main end
}//class end
