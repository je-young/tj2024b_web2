package example.day09;

import lombok.Builder;

@Builder
class MemberDto{
    private String name;
    private int age;

    public MemberDto( String name , int age ){
        this.name = name;
        this.age = age;
    }
} // end MemberDto


public class Example1 {
    public static void main(String[] args) {
        // (1) MemberDto(객체) 생성할때 멤버변수에 초기(처음) 값을 대입하는 방법 ( !!생성자!! )
        MemberDto memberDto = new MemberDto( "유재석" , 40 );
        //MemberDto memberDto1 = new MemberDto( ); // 존재하지 않은 생성자가 없어서 // 정의된 생성자의 매개변수를 일치하지 않아서
        //MemberDto memberDto2 = new MemberDto( 40 , "유재석" ); // 정의된 생성자의 매개변수를 일치하지 않아서
        //MemberDto memberDto3 = new MemberDto( "유재석" , 40 , "연예인"); // 정의된 생성자의 매개변수를 일치하지 않아서

        // 생성자 규칙 :
        // 1. 정의(만든)된 생성자만 사용이 가능하다. , 만든 생성자가 1개도 없을때는 기본생성자가 자동으로 생성된다.
        // 2. 매개변수 순서와 타입 , 개수 일치 해야한다.

        // 다양한 생성자를 사용하면 복잡도 올라간다. -> Builder Pattern
        // ! 빌더패턴 @Builder : 복잡한 객체 생성 과정을 단순화 해주는 디자인 패턴
        // (2) 롬복 제공하는 @Builder 어노테이션 객체 생성
            // 클래스명.builder().필드명(초기값).필드명(초기값).build(); : 빌더 객체를 생성
        MemberDto memberDto4 = MemberDto.builder().name("유재석").age(40).build();
        // name 필드에 "유재석", age 필드에 40을 설정하여 MemberDto 객체를 생성합니다.
            // 결과: name은 "유재석", age는 40인 객체가 생성됩니다.

        MemberDto memberDto5 = MemberDto.builder().build();
        // 어떤 필드도 설정하지 않고 MemberDto 객체를 생성합니다.
            // 결과: name과 age 모두 기본값(null 또는 0)을 가지는 객체가 생성됩니다.

        MemberDto memberDto6 = MemberDto.builder().name("유재석").build();
        // name 필드에 "유재석"을 설정하고 age 필드는 설정하지 않고 MemberDto 객체를 생성합니다.
            // 결과: name은 "유재석", age는 기본값(null 또는 0)을 가지는 객체가 생성됩니다.

        MemberDto memberDto7 = MemberDto.builder().age(40).name("유재석").build();
        // age 필드에 40, name 필드에 "유재석"을 설정하여 MemberDto 객체를 생성합니다.
            // 결과: name은 "유재석", age는 40인 객체가 생성됩니다. memberDto4와 같은 결과를 같지만 빌더에서 변수 지정 순서가 다릅니다.

    } // end main
} // end Example1


/*
    핵심 차이점:
    각 MemberDto 객체는 빌더를 사용하여 필드 값을 설정하는 방식에서 차이가 있음.
        - memberDto5는 빈 값을 가진 객체를 생성.
        - memberDto6은 name 에만 값을 넣고 age 는 비어있는 객체를 생성.
        - memberDto4와 memberDto7는 동일한 결과를 가지지만 빌더에서 변수 지정 순서가 다르다.
        - @Builder를 사용하면 필드의 순서에 상관없이 명시적으로 값을 설정할 수 있다.
        - 빌더 패턴을 사용하면 객체 생성 코드를 더 읽기 쉽고 명확하게 만들 수 있다.
    이러한 유연성 덕분에 @Builder는 복잡한 객체를 생성하거나 선택적 필드가 많은 객체를 다룰 때 유용하게 사용된다.
*/