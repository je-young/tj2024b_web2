package example.day10._멀티스레드;

// User1 Class
class User1 extends Thread {
    public Calculator calculator;
    @Override
    public void run() {
        calculator.setMemory(100);
    } // end run
} // end class

// User2 Class
class User2 extends Thread {
    public Calculator calculator;
    @Override
    public void run() {
        calculator.setMemory(200);
    } // end run
} // end class

// Calculator Class
class Calculator extends Thread {
    public int memory; // 멤버변수
    // public void setMemory(int memory) { // 비동기
    public synchronized void setMemory(int memory) { // 동기화 방법1 : 메소드 반환타입 앞에 'synchronized'
        synchronized (this) { // 동기화 방법2 : synchronized( 객체 )
            this.memory = memory;
            try {
                Thread.sleep(2000);
                // user1 스레드가 2초간 일시정지 도중에 user2 스레드가 200으로 대입 (병렬처리)
                // 주의할점 : 두개 이상의 스레드가 하나의 메소드 호출 할때 비동기 처리를 한다.
                // 두개 이상의 스레드가 하나의 메소드를 순서대로 호출 할때 동기 처리 한다.
                // -> 두개 이상의 스레드가 하나의 메소드를 요청하면 먼저 요청한 스레드가 종료될때 까지 다음 스레드는 대기
            } catch (Exception e) {
                System.out.println(e);
            } // end catch
            System.out.println(this.memory); // 100 200 x , 200 200 o
        } // end synchronized
    } // end setMemory
} // end class

// 실행 클래스
public class Example4 {
    public static void main(String[] args) {
        // 1. 계산기 객체 생성한다.
        Calculator calculator = new Calculator();
        // 2. 각 객체에 동일한 계산기를 대입
        User1 user1 = new User1();
        user1.calculator = calculator;
        User2 user2 = new User2();
        user2.calculator = calculator;
        // 3. 각 객체가 계산기에 대입하는 병렬처리
        user1.start(); // 100[x] 200
        user2.start(); // 200
    } // end main
} // end class
