package example.day06._aop과제.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper // MyBatis Mapper 인터페이스임을 스프링에게 알림 ( + @Component )
public interface TaskMapper {

    // [1] 학생 점수 등록
    // INSERT SQL 쿼리 작성 ( 데이터 삽입 ) ➕ 데이터 추가!
    @Insert(" insert into student( name , kor , math ) values( #{ name } , #{ kor } , #{ math } ) ")
    public int save(Map<String, Object> map );

    // [2] 학생 점수 전체조회
    // SELECT SQL 쿼리 작성 ( 데이터 조회 ) 🔍 데이터 주세요!
    @Select(" select * from student")
    public List<Map<String, Object>> findAll();
} // TaskMapper end
