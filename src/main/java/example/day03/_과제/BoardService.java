package example.day03._과제;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired private BoardMapper boardMapper;

    // [1] 글쓰기
    public int save(BoardDto boardDto){
        System.out.println("BoardService.save");
        System.out.println("BoardDto = " + boardDto);
        int result = boardMapper.save(boardDto);
        return result;
    } // save end

    // [2] 전체 글 조회
    public List<BoardDto> findall(){
        System.out.println("BoardService.findall");
        List<BoardDto> result = boardMapper.findall();
        return result;
    } // findall end

    // [3] 개별 글 조회
    public BoardDto find(int bno){
        System.out.println("BoardService.find");
        System.out.println("bno = " + bno);
        BoardDto result = boardMapper.find(bno);
        return result;
    } // find end

    // [4] 글 수정
    public int update(BoardDto boardDto){
        System.out.println("BoardService.update");
        System.out.println("boardDto = " + boardDto);
        int result = boardMapper.update(boardDto);
        return result;
    } // update end

    // [5] 개별 글 삭제
    public int delete(int bno){
        System.out.println("BoardService.delete");
        System.out.println("bno = " + bno);
        int result = boardMapper.delete(bno);
        return result;
    } // delete end
} // BoardService end
