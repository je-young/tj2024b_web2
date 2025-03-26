package example.day12._과제;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FruitStream {
    public static void main(String[] args) {

        List<String> 과일들 = List.of("사과", "바나나", "체리", "대추", "포도");

        System.out.println("=== 1. [메소드 레퍼런스 사용안함] forEach 출력 ===");
        // 1. [메소드 레퍼런스 사용안함] forEach 함수 활용(과일들을 하나씩 콘솔에 출력)
        과일들.stream()
                .forEach(과일 -> System.out.println("forEach 과일 : " + 과일));

        System.out.println("=== 2. [메소드 레퍼런스 사용안함] map 출력 ===");
        // 2. [메소드 레퍼런스 사용안함] map 함수 활용(과일들을 하나씩 콘솔에 출력)
        List<String> 과일들2 = 과일들.stream()
                .map(과일 -> {
                    System.out.println("map 과일 : " + 과일);
                    return 과일; // map 은 값을 반환해야 함
                })
                .collect(Collectors.toUnmodifiableList()); // 스트림 실행을 위한 최종 연산

        System.out.println("=== 3. [메소드 레퍼런스 사용안함] filter 출력 ===");
        // 3. [메소드 레퍼런스 사용안함] filter 함수 활용(과일들 중에 '바나나' 또는 '대추'만 콘솔에 출력)
        과일들.stream()
                .filter(과일 -> 과일.equals("바나나") || 과일.equals("대추"))
                .forEach(필터된과일 -> System.out.println("[filter] 필터된 과일 : " + 필터된과일));

        System.out.println("=== 4. [메소드 레퍼런스 사용안함] sorted 출력 ===");
        // 4. [메소드 레퍼런스 사용안함] sorted 함수 활용(과일들을 내리차순으로 콘솔에 출력)
        과일들.stream()
                .sorted(Comparator.reverseOrder()) // 내림차순 정렬
                .forEach(내림차순정렬된과일 -> System.out.println("[sorted] 내림차순 과일 : " + 내림차순정렬된과일));

        System.out.println("=== 5. [메소드 레퍼런스 사용함] forEach 출력 ===");
        // 5. [메소드 레퍼런스 사용함] forEach 함수 활용(과일들을 하나씩 콘솔에 출력)
        과일들.stream()
                .forEach(System.out::println);

        System.out.println("=== 6. [메소드 레퍼런스 사용함] map 출력 ===");
        // 6. [메소드 레퍼런스 사용함] map 함수 활용(과일들을 하나씩 콘솔에 출력)
        과일들.stream()
                .map(String::toString)
                .forEach(System.out::println);

        System.out.println("=== 7. [메소드 레퍼런스 사용함] filter 출력 ===");
        // 7. [메소드 레퍼런스 사용함] filter 함수 활용(과일들 중에 '바나나' 또는 '대추'만 콘솔에 출력)
        과일들.stream()
                .filter(과일 -> 과일.equals("바나나") || 과일.equals("대추"))
                .forEach(System.out::println);

        System.out.println("=== 8. [메소드 레퍼런스 사용함] sorted 출력 ===");
        // 8. [메소드 레퍼런스 사용함] sorted 함수 활용(과일들을 내리차순으로 콘솔에 출력)
        과일들.stream()
                .sorted(Comparator.reverseOrder()) // 내림차순 정렬
                .forEach(System.out::println);

    } // end main

} // end class
