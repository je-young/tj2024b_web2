package example.day11._스프링스케줄링._과제1;


import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskMapper taskMapper;

    // 30초마다 모든 상품 재고 감소
    @Scheduled(cron = "0/30 * * * * *")
    public void decreaseStockEvery30Seconds() {
        taskMapper.decreaseAllStocks();
        System.out.println("[시스템] 모든 제품이 30초 마다 3개 감소됨.");
    }

    // 1분마다 재고 현황 출력
    @Scheduled(cron = "0 * * * * *")
    public void printProductsEveryMinute() {
        List<Product> products = taskMapper.findAllProducts();
        System.out.println("\n===== 1분 마다 모든 재고 조회 =====");
        products.forEach(p -> System.out.println(p.toString()));
        System.out.println("===============================\n");
    }

    // 5분마다 재고 보충 작업
    @Scheduled(cron = "0 0/5 * * * *")
    public void restoreStockEvery5Minutes() {
        int count = taskMapper.restoreStockForLowInventory();
        System.out.printf("[시스템] %d 10개 이하 제품이 20개보충됨 %n", count);
    }

} // end class