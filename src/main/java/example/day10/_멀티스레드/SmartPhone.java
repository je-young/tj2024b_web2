package example.day10._멀티스레드;

import java.util.Scanner;

// 1. 음악 재생 기능을 담당하는 스레드
class MusicPlayer implements Runnable {
    // 음악 재생 여부를 저장하는 변수
    volatile boolean isPlaying = false;

    // 음악 재생 여부를 설정하는 메소드
    public void setPlaying(boolean playing) {
        isPlaying = playing;
        if (isPlaying) {
            System.out.println("음악 시작!");
        } else {
            System.out.println("음악 종료!");
        }
    } // setPlaying

    @Override
    public void run() {
        try {
            while (true) {
                if (isPlaying) {
                    System.out.println("음악 재생 중...");
                }
                Thread.sleep(1000); // 1초간 대기
            }
        } catch (InterruptedException e) {
            if (isPlaying) {
                System.out.println("음악 종료!");
            }
        }
    } // end run
} // end MusicPlayer

// 2. 웹서핑 기능을 담당하는 스레드
class WebSurfer implements Runnable {
    // 웹서핑 여부를 저장하는 변수
    volatile boolean isSurfing = false;

    // 웹서핑 여부를 설정하는 메소드
    public void setSurfing(boolean surfing) {
        isSurfing = surfing;
        if (isSurfing) {
            System.out.println("웹서핑 시작!");
        } else {
            System.out.println("웹서핑 종료!");
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (isSurfing) {
                    System.out.println("웹서핑 중...");
                }
                Thread.sleep(1000); // 1초간 대기
            }
        } catch (InterruptedException e) {
            if (isSurfing) {
                System.out.println("웹서핑 종료!");
            }
        }
    } // end run
} // end WebSurfer

// 3. 스마트폰 클래스
public class SmartPhone {
    public static void main(String[]args) {
        // 4. 음악 재생 스레드와 웹서핑 스레드 객체 생성
        MusicPlayer musicPlayer = new MusicPlayer();
        WebSurfer webSurfer = new WebSurfer();

        // 5. 스레드 객체를 Thread 객체에 전달
        Thread musicThread = new Thread(musicPlayer);
        Thread webThread = new Thread(webSurfer);

        // 6. 스레드 시작
        musicThread.start();
        webThread.start();

        // 7. 사용자 입력을 받기 위한 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 8. 사용자에게 메뉴 출력
            System.out.println("1. 뮤직 ON/OFF | 2. 웹서핑 ON/OFF | 0. 종료");
            System.out.print(">> ");
            int choice = scanner.nextInt();

            // 9. 사용자 입력에 따라 음악 재생 또는 웹서핑 상태 전환
            if (choice == 1) {
                musicPlayer.setPlaying(!musicPlayer.isPlaying);
            } else if (choice == 2) {
                webSurfer.setSurfing(!webSurfer.isSurfing);
            } else if (choice == 0) {
                System.out.println("스마트폰 종료...");
                // 10. 스레드를 안전하게 종료하기 위해 인터럽트 호출
                musicThread.interrupt();
                webThread.interrupt();
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        } // end while
        // 11. Scanner 객체 닫기
        scanner.close();
    } // end main
} // end SmartPhone