package example.day01._1스프링스레드;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ThreadService {

    //1.동기화
    public int thread1(){
        int result = 0; //값 지정 변수
        for( int i=0; i<=10; i++){ //반복문
            result +=1; //누적
            // ** 만약에 서비스처리가 늦어진다면 HTTP의 반환?? **
            try{ Thread.sleep(1000);
            }catch (Exception e){System.out.println(e);}//catch end
        }//for end
        return result;
    }//func end

    //2.
    @Async //응답 먼저하고 내부적으로 처리하는 상황
    public void thread2(){
        int result = 0;
        for (int i=0; i<=10; i++){
            result += 1;
            System.out.println("ThreadService.thread2");
            try {Thread.sleep(1000);
            } catch (InterruptedException e) {throw new RuntimeException(e);}//catch end
        }//for end
//        return result;
    }//func end
}//class end
