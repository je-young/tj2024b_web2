package example.day02._3과제;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BoardDao {

    // 게시물 저장 리스트(DB) , 번호 자동 증가
    private final List<BoardDto> boardTable = new ArrayList<>();
    private int auto_increment = 1;

    // 게시물 생성
    public boolean create(BoardDto boardDto) {
        boardDto.setBno(auto_increment);
        boardTable.add(boardDto);
        auto_increment++;
        return true;
    } //  create method end

    // 전체 게시물 조회
    public List<BoardDto> findAll() {
        return boardTable;
    } //  findAll method end

    // 개별 게시물 조회
    public BoardDto findByBno(int bno) {
        for (BoardDto boardDto : boardTable) {
            if (boardDto.getBno() == bno) {
                return boardDto;
            }
        }
        return null;
    } // findByBno method end

    // 게시물 수정
    public boolean update(BoardDto boardDto) {
        for (int i = 0; i < boardTable.size(); i++) {
            if (boardTable.get(i).getBno() == boardDto.getBno()) {
                boardTable.set(i, boardDto);
                return true;
            } // if end
        } // if end
        return false;
    } // update method end

    // 게시물 삭제
    public boolean delete(int bno) {
        for (int i = 0; i < boardTable.size(); i++) {
            if (boardTable.get(i).getBno() == bno) {
                boardTable.remove(i);
                return true;
            } // if end
        } // if end
        return false;
    } // delete method end

} // class end
