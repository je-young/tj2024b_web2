package example.day11._스프링스레드;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

// ============= 스프링에 내장된 스레드풀을 커스텀 / 설정 클래스 ============= //
@Configuration // [1] 스프링 설정 클래스 빈 등록
@EnableAsync
public class ThreadPoolConfig {

    // [1] 스레드풀 커스텀 메서드
    @Bean // (name = "taskExecutor")
    public Executor TaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor(); // 스레드풀 생성
        executor.setCorePoolSize(2); // 기본실행 스레드풀 개수
        executor.setMaxPoolSize(2); // 최대실행 스레드풀 개수
        executor.setQueueCapacity(10); // 대기 개수 설정 , 대기상타가 넘치면 503[오류]
        executor.initialize(); // 스레드풀 초기화
        return executor; // 설정한 스레드풀 객체 반환
    } // end TaskExecutor
} // end class
