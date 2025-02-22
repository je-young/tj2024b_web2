package example.day03._과제;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 1. HTTP servlet 매핑 지원 @Controller // 2. @ResponseBody 포함 // 3. 컨테이너 빈 등록 @Component
@RequestMapping("/day3/task/board") // 클래스내 메소드들의 공통 URL 지정
public class BoardController {

    // * 스프링 컨테이너에서 객체/인스턴스 를 주입
    @Autowired
    private BoardService boardService;

    // (1) 글쓰기 PostMapping  [POST] http://localhost:8080/day3/task/board  [BODY] {  "title": "" , "content" : ""}
    @PostMapping("")
    public boolean save( @RequestBody BoardDto boardDto ){
        System.out.println("BoardController.save");
        System.out.println("boardDto = " + boardDto);
        int result = boardService.save(boardDto);
        return result >= 1 ? true : false; // insert 성공시 true, 실패시 false 반환
    } // save end

    // (2) 전체 글 조회 GetMapping [GET] http://localhost:8080/day03/task/board
    @GetMapping("")
    public List<BoardDto> findall(){
        System.out.println("BoardController.findall");
        List<BoardDto> result = boardService.findall();
        return result;
    } // findall end

    // (3) 개별 글 조회 GetMapping [GET] http://localhost:8080/day03/task/board/view?bno=1 [queryString]
    @GetMapping("/view")
    public BoardDto find(@RequestParam("bno") int bno){
        System.out.println("BoardController.find");
        System.out.println("bno = " + bno);
        BoardDto result = boardService.find(bno);
        return result;
    } // find end

    // (4) 글 수정 PutMapping [PUT] http://localhost:8080/day03/task/board
    @PutMapping("")
    public boolean update( @RequestBody BoardDto boardDto ){
        System.out.println("BoardController.update");
        System.out.println("boardDto = " + boardDto);
        int result = boardService.update(boardDto);
        return result >= 1? true : false; // update 성공시 true, 실패시 false 반환
    } // update end

    // (5) 개별 글 삭제 DeleteMapping [DELETE] http://localhost:8080/day03/task/board?bno=1 [queryString]
    @DeleteMapping("")
    public boolean delete(@RequestParam("bno") int bno){
        System.out.println("BoardController.delete");
        System.out.println("bno = " + bno);
        int result = boardService.delete(bno);
        return result >= 1? true : false; // delete 성공시 true, 실패시 false 반환
    } // delete end


} // BoardController end


