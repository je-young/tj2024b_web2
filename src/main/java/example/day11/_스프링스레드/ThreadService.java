package example.day11._스프링스레드;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ThreadService {

    // (1) 비동기
    @Async // [2] 멀티스레드를 적용할 메소드 위에 @Async 어노테이션 추가
    public void thread1() {
        String name = UUID.randomUUID().toString();
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + "작업스레드 : " + name);
            try {
                Thread.sleep(1000); // 1초간 대기
            } catch (Exception e) {
                System.out.println(e);
            } // end catch
        } // end for
    } // end thread1

    // (2) 동기 , synchronized 키워드 추가
    @Async // [2] 멀티스레드를 적용할 메소드 위에 @Async 어노테이션 추가
    public synchronized void thread2() {
        String name = UUID.randomUUID().toString();
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + "작업스레드 : " + name);
            try {
                Thread.sleep(1000); // 1초간 대기
            } catch (Exception e) {
                System.out.println(e);
            } // end catch
        } // end for
    } // end thread1
} // end class
