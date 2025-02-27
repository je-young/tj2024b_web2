package example.day06.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Aspect
@Component
class Security {
    @Before("execution(* TestService2.*(..))")
    // 지정한 메소드가 실행되기 전에 아래 메소드가 실행 된다.
    // 지정한 메소드는 'TestService2' 클래스의 *(모든메소드) 이면서 (..)모든메개변수타입 *(모든리턴타입)
        // 'TestService2' 모든 메소드들은 실행되기전에 'securityCheck()' 메소드가 자동으로 실행된다
    public void securityCheck() {
        System.out.println("(보안) [코로나] 열 체크 + 자가진단");
    } // securityCheck end

    @After("execution( * example.day06.aop.TestService2.enter1(..))")
    // 지정한 메소드가 실행된 후에 아래 메소드가 실행 된다
    // 지정한 메소드는 'TestService2' 클래스의 'enter1' 메소드이면서 (..)모든메개변수타입 *(모든리턴타입)
        // 'TestService2.enter1()' 메소드은 실행된 후에 'securityCheck2()' 메소드가 자동으로 실행된다
    public void securityCheck2() {
        System.out.println("함수 실행 종료");
    } // securityCheck2 end

    // [3]
    @Before("execution( * example.day06.aop.TestService2.enter3(..)) && args(name)")
    // 지정한 메소드에서 name 매개변수를 가지고 와서 아래 메소드에서 사용이 가능하다.
        // 로그처리, 보안검사, 트랜젝션 등등 하기 위해서
    public void securityCheck3( String name ) {
        System.out.println("메소드 실행 전(before): " + name + "님이 코로나 검사 완료");
    } // securityCheck3 end

    // [4]
    @AfterReturning(value = "execution( * example.day06.aop.TestService2.enter3(..))" , returning = "result")
    // 지정한 메소드가 정상적으로 실행 되었을때 result 리턴값을 가지고 와서 아래 메소드에서 사용이 가능하다.
    public void securityCheck4( Object result ) {
        System.out.println("메소드 실행 후(after): " + result +" 이/가 결과값 정상");
    } // securityCheck4 end

    // [5] 메소드 실행 시간 체크 , 검증
    @Around("execution( * example.day06.aop.TestService2.enter3(..))")
    public Object timeCheck5( ProceedingJoinPoint joinPoint ) throws Throwable {
        // proceeding.joinPoint : 지정한 메소드 와 추가적인 로직과 조합에서 구현
        // --> 추가 로직에서 직접 지정한 메소드 호출 : joinPoint.proceed(); , 예외처리 필수
        // (1) 시작 시간
        long startTime = System.currentTimeMillis();
        // (*) // 지정된 메소드( 'enter3' ) 실행
        Object result = joinPoint.proceed();
        // (2) 종료 시간
        long endTime = System.currentTimeMillis();
        // (3) 지정된 메소드가 실행되었을때 걸린시간 계산
        long time = endTime - startTime;
        // (4) 시간 계산 결과 출력
        System.out.println("메소드 실행 시간: " + time + "ms");
        // (5) 지정된 메소드가 리턴한 값 그대로 리턴
        return result;
    } // timeCheck5 end
} // Security end

@Service
class TestService2 {
    // 메소드1
    public void enter1() {
        // 부가기능 제외한 상태
        System.out.println("식당 입장"); // 비지니스
    } // enter1 end

    // 메소드2
    public void enter2() {
        // 부가기능 제외한 상태
        System.out.println("학원 입장"); // 비지니스
    } // enter2 end

    // 메소드3
    public boolean enter3( String name ) {
        // 부가기능 제외한 상태
        System.out.println("헬스장 입장"); // 비지니스
        return true;
    } // enter3 end
} // TestService2 end

@RestController
class TestController2 {
    @Autowired private TestService2 testService2;
    @GetMapping("/day06/aop")
    public void aop() {
        testService2.enter1();
        testService2.enter2();
        testService2.enter3("강호동");
    } // aop end
} // TestController2 end

@SpringBootApplication
public class Example2 {
    public static void main(String[] args) {
        SpringApplication.run(Example2.class);
    } // main end
} // Example2 end

