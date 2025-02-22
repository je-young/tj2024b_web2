package example.day03._과제;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // (마이바티스 [DB연동 라이브러리] )
public interface BoardMapper {
    // [1] 글 등록 SQL 처리하는 XML 매상메소드
    int save(BoardDto boardDto);
    // [2] 글 전체 조회 SQL 처리하는 XML 매소드
    List<BoardDto> findall();
    // [3] 글 개별 조회 SQL 처리하는 XML 매소드
    BoardDto find(int bno);
    // [4] 글 수정 SQL 처리하는 XML 매소드
    int update(BoardDto boardDto);
    // [5] 글 개별 삭제 SQL 처리하는 XML 매소드
    int delete(int bno);
}
