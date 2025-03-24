package example.day10._멀티스레드;


import java.time.LocalTime;
import java.util.Scanner;

class 시간클래스 implements Runnable{
    @Override
    public void run() {
        try {
            while (true) { // 무한루프
                System.out.println("시간클래스 : " + LocalTime.now()); // LocalTime.now() : 현재 시스템 시간 반환함수.
                Thread.sleep(1000); // 1초간 일시정지
            } // end while
        } catch (Exception e) {
            System.out.println(e);
        } // end catch
    } // end run
} // end class

class 타이머클래스 extends Thread{

    boolean state = true; // 무산루프 샐행여부
    @Override
    public void run() {
        int second = 0;
        try {
            while (state) {
                Thread.sleep(1000); // 1초간 일시정지
                second++;
                System.out.println("타이머클래스 : " + second + "초");
            } // end while
        } catch (Exception e) {
            System.out.println(e);
        } // end catch
    } // end run
} // end class

public class Example3 {
    public static void main(String[] args) {
        // 1. ( 작업 스레드 )현재 시간을 출력하는 스레드
        시간클래스 runnable1 = new 시간클래스(); // 구현객체
        Thread thread1 = new Thread(runnable1); // 새로운 스레드 생성
        thread1.start(); // 스레드 실행

        // 2. ( main 스레드 )입력받기
        타이머클래스 thread2 = new 타이머클래스();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("타이머 1.ON 2. OFF : ");
            int ch = scanner.nextInt();
            if (ch == 1) {
                System.out.println("** 타이머 시작 **");
                // 3. ( 작업 스레드 ) 타이머를 출력하는 스레드 추가
                if (!thread2.isAlive()) {
                    thread2.start();
                }
            } else if (ch == 2) {
                System.out.println("** 타이머 종료 **");
                thread2.state = false;
                thread2.interrupt(); // 스레드 종료
            } // end if
        } // end while

    } // end main
} // end class
