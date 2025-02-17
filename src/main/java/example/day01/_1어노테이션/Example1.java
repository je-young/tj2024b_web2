package example.day01._1어노테이션;

import java.lang.reflect.Method;

class SuperClass { // 상위 클래스 // 부모
    public void method1() { // 메소드
    } // method1 end
} // SuperClass end

class SubClass extends SuperClass { // 하위 클래스 // 자식 // executed 부모클래스{}

    @Override // 부모 클래스로 부터 물려받은 메소드를 재정의(내부코드 수정) 한다. // 부모 클래스
    public void method1() { // 메소드}
        super.method1();
    } // method1 end
    @Deprecated
    public void method2() {} // method2 end
} // SubClass end

    // [1] 어노테이션 만들기
    @interface Annotation1{
        // 주요메소드
        String value1();
    } // Annotation1 end

    // [2] 어노테이션 사용하기
    class TestClass {
        @Annotation1( value1 = "value1 값 저장" )
        public void method3() {
            // value1 이라는 값을 사용할 수 있다.( 내부적으로 )
            System.out.println(value1); // sout
        } // method3 end
    } // class TestClass end


public class Example1 {
    // main + 엔터
    public static void main(String[] args) {
        // * 기본 어노테이션 사용
        SubClass subClass = new SubClass(); // SubClass 객체 생성
        subClass.method1(); // 오버라이딩된 메소드
        subClass.method2(); // 비권장(더이상 사용하지않는) 메소드
        // [3] 리플렉션 된 클래스 정보 확인
        Method method = TestClass.class.getMethod("method3");
        Annotation1 annotation1 = method.getAnnotation( Annotation1.class );
        System.out.println( annotation1.value1() );
    } // main end
} // Example1 end

/*
    [1] 인텔리제이 자동 완성 (대소문자 구별)
        1. 자동 완성 할 문자 몇개 입력하면 자동으로 아래에 여러가지 추천 코드 나온다.
    [2] TabNine 플러그인 자동완성 ( 한글 지원 X)
        1. 코드 작성후 엔터 치면 자동으로 추천 코드를 확인후 [Tab]
        2. [ESC] 취소
*/