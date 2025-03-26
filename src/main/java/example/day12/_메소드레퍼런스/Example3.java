package example.day12._메소드레퍼런스;


import java.util.List;
import java.util.function.Supplier;

class Person {
    String name; // 멤버변수
    public Person() {} // 기본 생성자
    public Person(String name) { // 매개변수 1개 생성자
        this.name = name;
    } // end constructor


    // 일반 메서드
    public void onMessage1(String message) {
        System.out.println("일반 message : " + message);
    } // end method

    // static 메서드
    public static void onMessage2(String message) {
        System.out.println("static message : " + message);
    } // end method

} // end class


public class Example3 {
    public static void main(String[] args) {
        // * 임의의 컬렉션
        List< String > names = List.of("유재석", "강호동", "신동엽");

        // 1. static 메서드 참조
            // (1) 일반적인 방법
        names.forEach( name -> Person.onMessage2(name) );
            // (2) 메서드 레퍼런스 방법 , ::(콜론2개)
                // forEach 매개변수 와 static 메서드의 매개변수 일치
                // 클래스명::static메서드명
        names.forEach( Person::onMessage2 );

        // 2. 생성자 참조
            // (1) 일반적인 방법
        names.forEach((name) -> { new Person(name); } );
            // (2) 생성자 레퍼런스 방법 ,
                // forEach 매개변수 와 생성자의 매개볮수 일치
                // 클래스명::new
        names.forEach( Person::new );

        // 3. 일반 메서드 참조
            // 객체명::메서드명
        Person person1 = new Person();
        names.forEach( person1::onMessage1 );

        // 4. 주의할점 , :: 메서드레퍼런스 , 람다 표현식 간결
        // Person person2 = Person::new;
        Supplier< Person > ref = Person::new;
        Person person = ref.get();
            // vs
        Supplier< Person > ref2 = () -> new Person();

    } // end main
} // end class
