package example.day01._2스케줄링;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    //1. 3초마다 자동으로 실행 하는 서비스 메소드
    // @Scheduled(fixedRate = 밀리초) 밀리초란? 1000의1초
    @Scheduled(fixedRate = 3000)
    public void task1(){
        System.out.println("[3초] ScheduleService.task1");
    }//func end

    //2. 5초 마다 자동으로 실행 하는 서비스 메소드
    final int time = 5000; // 계산식 또는 변수 사용시 final(상수) 사용한다.
    @Scheduled(fixedRate = time )
    public void task2(){
        System.out.println("[5초]ScheduleService.task2");
    }//func end

    // * (서버)시스템 날짜/시간 기준으로 자동실행 스케줄링(백그라운드/비동기/멀티스레드)
    // 3. 현재 시스템의 매 시간 0:0:5초 가 될때 마다 자동실행
    //@Scheduled(cron=초 분 시 일 월 요일)
    @Scheduled(cron="*/5 * * * * *")
    public void task3(){
        System.out.println("[cron 5초]ScheduleService.task3");
    }//func end

    @Scheduled(cron="0 */1 * * * * ") //1분 마다
    public void task4(){
        System.out.println("[cron 1분]ScheduleService.task3");
    }//func end
}//class end
