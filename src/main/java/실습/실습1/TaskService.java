package 실습.실습1;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskDao taskDao;

    // 1. 30초 마다 모든 제품의 재고는 3개씩 감소
    @Scheduled(cron =" 0/30 * * * * *")
    public void task1(){
        System.out.println("TaskService.task1");
        taskDao.productCount();
    }//func end

    // 2. 1분 마다 모든 제품 정보를 조회/출력 한다.
    @Scheduled(cron =" 0 0/1 * * * *")
    public void task2(){
        System.out.println("TaskService.task2");
        List<Map<String,String>> Product = taskDao.productPrint();
        for(Map<String,String> product : Product ){
            System.out.printf("[ID] :%s "+"[NAME] :%s "+"[STOCK] :%s \n",product.get("id"),product.get("name"),product.get("stock"));
        }
        taskDao.productPrint();
    }//func end

    //3. 매 5분마다 재고가 10 이하인 상품의 재고를 +20개 추가한다.
    @Scheduled(cron = " 0 0/5 * * * *")
    public void task3(){
        System.out.println("TaskService.task3");
        taskDao.productCountTwo();
    }//func end

}// class end
