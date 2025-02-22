package example.day03._과제;


import lombok.*;

@Getter@Setter@ToString@Builder
@NoArgsConstructor@AllArgsConstructor
public class BoardDto {
    private int bno;               // 게시글 번호
    private String title;          // 게시글 제목
    private String content;        // 게시글 내용

}
