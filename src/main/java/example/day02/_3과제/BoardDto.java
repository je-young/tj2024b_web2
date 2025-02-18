package example.day02._3과제;

import lombok.*;

@Setter@Getter@ToString
@AllArgsConstructor@NoArgsConstructor // lombok 라이브러리를 사용하여 자동생성
public class BoardDto {
    private int bno;            // 게시물 번호
    private String btitle;      // 게시물 제목
    private String bcontent;    // 게시물 내용
} // f end


