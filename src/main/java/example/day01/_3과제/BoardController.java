package example.day01._3과제;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day01/task")
public class BoardController {

    // 임시 데이터 저장용 리스트
    private List<Map<String, String>> boardList = new ArrayList<>();

    // 1. 글쓰기
    @PostMapping("/board") // http://localhost:8080/day01/task/board
    public boolean writeBoard() {
        // 임시 데이터 추가
        Map<String, String> newBoard = new HashMap<>();
        newBoard.put("bno", String.valueOf(boardList.size() + 1));
        newBoard.put("btitle", "새 글 제목");
        boardList.add(newBoard);
        return true; // 글쓰기 성공
    }

    // 2. 전체 글 조회
    @GetMapping("/board") // http://localhost:8080/day01/task/board
    public List<Map<String, String>> getBoardList() {
        // 임시 데이터 반환
        return boardList;
    }

    // 3. 개별 글 조회
    @GetMapping("/board/view") // http://localhost:8080/day01/task/board/view/1
    public Map<String, String> getBoard() {
        // 임시 데이터 반환
        Map<String, String> board = new HashMap<>();
        board.put("bno", "1");
        board.put("btitle", "제목1");
        return board;
    }

    // 4. 개별 글 수정
    @PutMapping("/board") // http://localhost:8080/day01/task/board
    public boolean updateBoard() {
        // 임시로 수정 성공 처리
        return true;
    }

    // 5. 개별 글 삭제
    @DeleteMapping("/board") // http://localhost:8080/day01/task/board
    public int deleteBoard() {
        // 임시로 삭제한 글 번호 반환
        return 3;
    }
}