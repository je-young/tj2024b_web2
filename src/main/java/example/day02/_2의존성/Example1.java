package example.day02._2의존성;

/*
    [고전적인 방법1 : 인스턴스 생성 ]
    스프링 없이 객체(인스턴스)를 직접 생성하여 메소드를 사용한다.
    - 단점 : 강한 결합 으로 유지보수가 어려워진다.
*/
// [1] 서비스 클래스
class SampleService1 {
    void method(){
        System.out.println("SampleService1.method"); // soutm
    } // f end
} // c end

// [2] 컨트롤러 클래스
class sampleController1 {
    // 다른 클래스와 메소드를 호출하는 방법
    SampleService1 sampleService1 = new SampleService1();
    public void method(){
        // 서비스클래스의 메소드 호출
        sampleService1.method(); // 서비스 클래스 의 method() 호출
    } // f end
} // c end

public class Example1 { } // c end
