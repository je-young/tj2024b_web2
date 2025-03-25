package example.day11._스레드풀;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example1 {

    // * main 함수 안에 main 스레드(코드를 읽어드리는 역할)
    public static void main(String[] args) {

        // 반복문 이용하여 5개의 작업 스레드 생성
        for (int i = 1; i <= 5; i++) {
            // (1) 작업 스레드 생성 , hread thread = new Thread(new Runnable() {})
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                    Thread.sleep(1500); // 1.5초간 대기
                    System.out.println("작업 스레드 : 실행중 ");
                    } catch (Exception e) {
                        System.out.println(e);
                    } // end catch
                } // end run
            }); // end Runnable
        thread.start();
        } // end for
        // [2] 반복문 이용하여 반복문 횟수만큼 지정된 작업 스레드에 배정하여 실행 , 스레드풀
            // (1) 스레드풀 생성 ( 고정된 스레드 개수 ) , Executors.newFixedThreadPool(고정개수);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
            // (2) 반복문
        for (int i = 1; i <= 10; i++) {
            String name = "thread" + i;
            // (3) 새로운 스레드가 아닌 스레드풀에 정의한 스레드를 등록한다. , .submit( 등록할스레드인터페이스 )
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000); // 2초간 대기
                        System.out.println("작업 스레드 : 실행중 " + name);
                    } catch (Exception e) {
                        System.out.println(e);
                    } // end catch
                } // end run
            }); // end Runnable
        } // end for
        // (4) 스레드풀 종료 , .shutdown()
        executorService.shutdown();
    } // end main
} // end class
