package example.day06._aop과제.controller;


import example.day06._aop과제.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController // HTTP 요청/응답 처리, JSON 데이터 응답 ( @Controller + @ResponseBody ) ( + @Component )
@RequestMapping("/day06/task") // http://localhost:8080/day06/task
public class TaskController {

    @Autowired // 스프링 컨테이너에서 빈(Bean) 을 자동으로 주입 (의존성 주입 - DI) 🧩 부품 연결!
    private TaskService taskService;

    // [1] 학생 점수 등록
    @PostMapping("")
    public int save( @RequestBody Map< String , Object > map ){
        return taskService.save( map );
    } // save end

    // [2] 학생 점수 전체 조회
    @PostMapping("")
    public List<Map< String , Object >> findAll(){
        return taskService.findAll();
    } // findAll end

} // TaskController end
