package example.day02._3과제;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day02/task2/board") // 공통 URL : /day02/task2/board
public class BoardController2 {

    private final BoardDao boardDao; // Board 의존성 주입을 위한 필드 선언

    @Autowired // 생성자를 이용한 의존성 주입
    public BoardController2(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    // 게시물 생성 API : POST 요청
    @PostMapping("") // POST 요청 URL 매핑 "" 기본 URL 에 추가 http://localhost:8080/day02/task2/board
    public boolean create(@RequestBody BoardDto boardDto) { // @RequestBody : 요청 body -> BoardDto 로 매핑
        return boardDao.create(boardDto); // BoardDao 에 create() 메소드 호출
    } // create method end

    // 전체 게시물 조회 API : GET 요청
    @GetMapping("") // GET 요청 URL 매핑 "" 기본 URL 에 추가 http://localhost:8080/day02/task2/board
    public List<BoardDto> findAll() { // 반환 타입 : List<BoardDto> (JSON 응답)
        return boardDao.findAll(); // BoardDao 에 findAll() 메소드 호출
    } // findAll method end

    // 개별 게시물 조회 API : GET 요청
    @GetMapping("/view") // GET 요청 URL 매핑 "/view" 기본 URL 에 추가됨 http://localhost:8080/day02/task2/board/view?bno=1
    public BoardDto findByBno(@RequestParam(name = "bno") int bno) { // @RequestParam : 쿼리 스트링 "bno" 매핑
        return boardDao.findByBno(bno); // BoardDao 에 findByBno() 메소드 호출
    } // findByBno method end

    // 개별 게시물 수정 API : PUT 요청
    @PutMapping("") // PUT 요청 URL 매핑 "" 기본 URL 에 추가됨 http://localhost:8080/day02/task2/board
    public boolean update(@RequestBody BoardDto boardDto) { // @RequestBody : 요청 body -> BoardDto 로 매��
        return boardDao.update(boardDto); // BoardDao 에 update() 메소드 호출
    } // update method end

    // 개별 게시물 삭제 API : DELETE 요청
    @DeleteMapping("") // DELETE 요청 URL 매핑 "" 기본 URL 에 추가됨 http://localhost:8080/day02/task2/board
    public boolean deleteByBno(@RequestParam(name = "bno") int bno) { // @RequestParam : 쿼리 스트링 "bno" 매핑
        return boardDao.delete(bno); // BoardDao 에 deleteByBno() 메소드 호출
    } // deleteByBno method end

} // class end
