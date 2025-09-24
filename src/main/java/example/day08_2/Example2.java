package example.day08_2;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

// [4]AOP 커스텀
@Aspect // AOP 클래스를 스프링 컨테이너 등록, AOP 설정하겠다는 어노테이션
@Component // AOP 클래스를 스프링 빈(객체)컨테이너에 등록
class AopClass{
    //[4-1] 애플리케이션 내 AopService내 모든 메소드가 실행 되면 같이 실행
    //@Before("execution(경로와 조건)")
    // * : 모든 리턴 타입의 메소드들
    // java 이하경로부터  : 적용할 메소드가 위치한 패키지/파일 경로
        // -> 같은패키지 : 클래스명만작성 AopService
        // -> 다른패키지 : example.day08_2.AopService
    // .메소드명
        // .* : 해당 클래스내 메소드에 적용
        // .enter1 : 해당 클래스내 enter1 에만 적용
    // (매개변수)
        // .(..) : 해당 메소드의 모든 매개변수를 갖는곳에 적용
        // .enter1(int,boolean) : 지정한 매개변수를 갖는 메소드만 적용
    // [4-2]
    @Before("execution( * AopService.*(..) )")
    public void check1(){
        System.out.println("[코로나] 열 체크");
    }//func end
    // [4-3]
    //("execution(리턴타입패키지/클래스경로,메소드명(매개변수타입,매개변수타입");
    @After("execution( * example.day08_2.AopService.enter1(..))")
    public void check3(){
        System.out.println("[4-3] enter1 에서 AOP");
    }//func end

    //[4-4] &&args(인자들) 매개변수 값들을 연결/바인딩 할 이름 정의
    @Before("execution( boolean example.day08_2.AopService.enter3(String))&&args(name)")
    public void check4(String name){
        System.out.println("[4-4] enter3 에서 AOP [매개변수]"+name);
    }//func end

    //[4-5] @AfterReturning(returning = "바인딩할 변수명") 리턴값을 반환 받을 수 있다.
    @AfterReturning(
            value = "execution ( boolean example.day08_2.AopService.enter3(..))",
            returning = "result" //리턴값을 매핑/바인딩 할 이름 정의
    )
    public void check5(boolean result){
        System.out.println("[4-5] enter3 에서 AOP [반환값]"+result);
    }//func end

    //[4-6] 개발자가 직접 메소드를 실행하는 시점
    @Around("execution( * example.day08_2.AopService.enter3(..))")
    public Object check6(ProceedingJoinPoint joinPoint) throws Throwable {
    // 리턴 타입을 * 했으므로 모든 자료들을 저장하기 위해 Object
    // 매개변수에는 'ProceedingJoinPoint' 라는 비즈니스로직 과 조합
        System.out.println("[4-6]객체확인"+joinPoint); // 1. 객체확인
        System.out.println("[4-6]실행할 메소드명"+joinPoint.getSignature()); // 2. 해당 AOP 메소드를 실행한 비즈니스함수 확인
        System.out.println("[4-6]실행할 메소드의 인자들"+ Arrays.toString(joinPoint.getArgs()));              // 3. 실행한 대상(메소드) 매개변수의 인자들(배열) 확인
        Object result = //실행 결과를 반환도 받을수 있다.
        joinPoint.proceed();// 4. 실행할 대상 메소드를 직접 실행(실행 시점 커스텀 가능),*예외처리*
        System.out.println("[4-6]실행 후 메소드의 반환값"+result);
        return result; // 5. 실행한 대상 메소드의 리턴값을 그대로 리턴 해야 한다.
    }
}//class end


//[3]간단한 서비스
@Service
class AopService{
    public void enter1(){
        System.out.println("===학원 입장===");
    }//func end

    public void enter2(){
        System.out.println("===식당 입장===");
    }

    public boolean enter3(String name){
        System.out.println("===헬스 입장===");
        return true; //임의의 데이터
    }//func end
}//class end


//[2]간단한 HTTP 컨트롤러
@RestController
@RequiredArgsConstructor
class AopController{
    private final AopService aopService;
    @GetMapping("/day08/aop")
    public void method(){
        aopService.enter1();
        aopService.enter2();
        aopService.enter3("테스트");
    }
}//class end

//[1]
@SpringBootApplication
public class Example2 {
    public static void main(String[] args) {
        SpringApplication.run(Example2.class);
    }//main end
}//class end


// AOP : 관점지향 프로그래밍
// 부가기능을 하나로 모듈화 해서 핵심비즈니스 로직 분리
// 예] 로그(기록),트랜잭션(SQL시작/종료), 보안(인증/권한) 등등

//1. AOP 라이브러리 설치
