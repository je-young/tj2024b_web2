package example.day10._멀티스레드;

import java.awt.*;

public class Example1 {
    // 1. main 함수는 main 스레드를 포함하며 코드를 첫 시작한다.
    public static void main(String[] args) {
        System.out.println("(1) main 스레드가 읽어드리는 코드");

        // 2. main 함수 안에서 작성된 코드는 모두 main 스레드가 읽어드린다.
        for (int i = 1; i < 5; i++) {
            System.out.println("(2) main 스레드가 읽어드리는 코드" + i);
        } // end for

        // 3. ================================== 싱글 스레드 ===========================================//
        System.out.println("===================== 싱글 스레드 시작 ======================");
        Toolkit toolkit = Toolkit.getDefaultToolkit(); // Java UI 제공하는 패키지 ( java.awt.Toolkit )
        // 3-1 소리 5번 발생
        for (int i = 1; i <= 5 ; i++) {
                toolkit.beep(); // 비프음( '띵' ) 발생
            // * 스레드 일시정지
            try {
                // * 스레드 일시정지
                Thread.sleep(1000); // Thread.sleep( 밀리초 ); 예외발생
            } catch (Exception e) {
                System.out.println(e);
            } // end catch
        } // end for

        // 3-2 출력 5번 발생
        for (int i = 1; i <= 5 ; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            } // end catch
        } // end for

        // 4. ================================== 멀티 스레드 (1) 익명 객체 ===========================================//
        System.out.println("===================== 멀티 스레드 (1) 익명 객체 시작 ======================");
        // 4-1 : 소리 5번 발생 , 작업스레드 정의
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() { // 추상메소드
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for (int i = 1; i <= 5 ; i++) {
                        toolkit.beep(); // 비프음
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println(e);
                    } // end catch
                } // end for
            } // end run
        }); // end thread
        // 작업스레드 실행
        thread.start();
        // 4-2 : 출력 5번 발생 , (위 예제 코드 복사해오기.)
        for( int i = 1 ; i <= 5 ; i++ ) {
            System.out.println("띵");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            } // end catch
        } // end for

        // 5. ================================== 멀티 스레드 (2) 구현 객체 ===========================================//
        System.out.println("===================== 멀티 스레드 (2) 구현 객체 시작 ======================");
        // 5-1 : 소리 5번 발생 , 작업스레드 정의
        비프음1 비프음1 = new 비프음1();
        Thread 비프음스레드1 = new Thread(비프음1);
        비프음스레드1.start();
        // 5-2 : 출력 5번 발생 , (위 예제 코드 복사해오기.)
        for( int i = 1 ; i <= 5 ; i++ ) {
            System.out.println("띵");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            } // end catch
        } // end for

        // 6. ================================== 멀티 스레드 (3) 상속 객체 ===========================================//
        System.out.println("===================== 멀티 스레드 (3) 상속 객체 시작 ======================");
        // 6-1 : 소리 5번 발생 , 작업스레드 정의
        비프음2 비프음2 = new 비프음2();
        비프음2.start();

        // 6-2 : 출력 5번 발생 , (위 예제 코드 복사해오기.)
        for( int i = 1 ; i <= 5 ; i++ ) {
            System.out.println("띵");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            } // end catch
        } // end for
    } // end main
} // end class

/*
    1. 스레드(Thread)란?
        - 프로세스(Process): 실행 중인 하나의 프로그램. 예를 들어, 웹 브라우저, 워드 프로세서 등이 하나의 프로세스.
            운영체제는 각각의 프로세스에 독립적인 메모리 공간을 할당.
        - 스레드(Thread): 하나의 프로세스 안에서 실제로 작업을 수행하는 작은 단위. 하나의 프로세스는 하나 이상의 스레드를 가질 수 있다.
            마치 하나의 큰 작업(프로세스)을 여러 명의 작업자(스레드)가 나누어서 처리하는 것과 같다.

    2. 싱글 스레드(Single Thread)와 멀티 스레드(Multi Thread)
        - 싱글 스레드: 하나의 프로세스에 스레드가 하나만 있는 경우. 이 경우, 작업은 순차적으로 하나씩 처리.
            마치 한 명의 작업자가 모든 일을 혼자서 처리하는 것과 같다. 코드에서 3번 "싱글 스레드" 부분이 이에 해당.
            소리 발생 작업이 5번 실행된 후, "띵" 출력 작업이 5번 실행되는 것을 볼 수 있다. 즉, 한 작업이 끝나야 다음 작업이 시작된다.
        - 멀티 스레드: 하나의 프로세스에 여러 개의 스레드가 있는 경우. 여러 작업을 동시에 처리할 수 있다.
            마치 여러 명의 작업자가 동시에 여러 일을 처리하는 것과 같다. 코드에서 4, 5, 6번 "멀티 스레드" 부분이 이에 해당.
            소리 발생 작업과 "띵" 출력 작업이 동시에 진행되는 것을 확인할 수 있다.

    3. Java에서의 스레드 구현 방법 : Java 에서는 주로 두 가지 방법으로 스레드를 구현한다.
        - `Runnable` 인터페이스 구현: `Runnable` 인터페이스를 구현하는 클래스를 만들고, `run()` 메소드 안에 스레드가 실행할 코드를 작성.
            이 방법은 이미 다른 클래스를 상속받고 있는 경우에 유용.
        - `Thread` 클래스 상속: `Thread` 클래스를 상속받는 클래스를 만들고, `run()` 메소드를 오버라이딩하여 스레드가 실행할 코드를 작성.

    4. 코드 분석 : 코드의 각 부분이 어떻게 스레드 활용확인
        - 4.1. `main` 메소드:
            `main` 메소드는 프로그램의 시작점이며, `main` 스레드라는 특별한 스레드에서 실행. 코드의 1번과 2번 주석에서 이를 설명하고 있음.
        - 4.2. 싱글 스레드 (3번):
            `main` 스레드 안에서 모든 작업을 순차적으로 처리. `toolkit.beep()`으로 소리를 5번 내고, 그 후에 "띵"을 5번 출력.
        - 4.3. 멀티 스레드 (1) 익명 객체 (4번):
            `Thread` 클래스의 생성자에 `Runnable` 인터페이스를 익명으로 구현한 객체를 전달하여 새로운 스레드를 생성.
                익명 객체의 `run()` 메소드 안에는 소리를 5번 발생시키는 코드가 있음.
            `thread.start()`를 호출하면 새로운 스레드가 생성되어 `run()` 메소드의 코드를 실행.
                `main` 스레드는 이후의 "띵" 출력 코드를 계속 실행. 결과적으로 소리 발생 작업과 "띵" 출력 작업이 거의 동시에 진행되는 것처럼 보인다.
        - 4.4. 멀티 스레드 (2) 구현 객체 (5번):
            `비프음1` 클래스는 `Runnable` 인터페이스를 구현하고 `run()` 메소드 안에 소리 발생 코드를 가지고 있다.
            `비프음1` 클래스의 `비프음1` 객체를 생성하고, 이 객체를 `Thread` 클래스의 생성자에 전달하여 새로운 스레드를 생성.
            `비프음스레드1.start()`를 호출하여 새로운 스레드를 시작.
            `main` 스레드는 이후의 "띵" 출력 코드를 계속 실행.
                이전 익명 객체 방식과 동일하게 소리 발생과 "띵" 출력이 동시에 진행.
        - 4.5. 멀티 스레드 (3) 상속 객체 (6번):
            `비프음2` 클래스는 `Thread` 클래스를 상속받고 `run()` 메소드를 오버라이딩하여 소리 발생 코드를 가지고 있다.
            `비프음2` 객체를 생성하고, `비프음2.start()`를 호출하면 새로운 스레드가 생성되어 `run()` 메소드의 코드를 실행.
            `main` 스레드는 이후의 "띵" 출력 코드를 계속 실행.
            마찬가지로 소리 발생과 "띵" 출력이 동시에 진행.

    5. `run()` vs `start()`
        - `run()` 메소드: 단순히 해당 스레드가 실행할 코드를 정의하는 메소드.
            이 메소드를 직접 호출하면 현재 스레드(예: `main` 스레드)에서 해당 코드가 순차적으로 실행될 뿐, 새로운 스레드가 생성되지 않는다.
        -`start()` 메소드: 새로운 스레드를 생성하고, 생성된 스레드에서 `run()` 메소드를 실행하도록 요청하는 메소드.
            멀티 스레딩을 위해서는 반드시 `start()` 메소드를 호출해야 한다.

    [ 요약 ]
        코드는 싱글 스레드 방식과 세 가지 다른 멀티 스레드 구현 방식을 보여주고 있다. 멀티 스레드를 사용하면 여러 작업을 동시에 처리하여 프로그램의 응답성을 높일 수 있다.
*/
