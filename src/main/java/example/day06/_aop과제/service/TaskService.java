package example.day06._aop과제.service;


import example.day06._aop과제.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service // 해당 클래스를 스프링 서비스 컴포넌트 로 등록 ( + @Component )
public class TaskService {

    @Autowired // 스프링 컨테이너에서 빈(Bean) 을 자동으로 주입 (의존성 주입 - DI) 🧩 부품 연결!
    private TaskMapper taskMapper;

    // [1] 학생 점수 등록
    public int save( Map< String , Object > map ){
        System.out.println("TaskService.save"); // soutm 자동완성 : 메소드명 출력
        System.out.println("map = " + map); // soutp 자동완성 : 매개변수 출력
        return taskMapper.save( map );
    } // save() end

    // [2] 학생 전체 조회
    public List<Map< String , Object >> findAll(){
        return taskMapper.findAll();
    } // findAll() end

} // TaskService end
