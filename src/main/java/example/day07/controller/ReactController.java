package example.day07.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/day07/react")
@CrossOrigin("http://localhost:5173") // CORS 정책허용
public class ReactController {
  
  // (샘플 데이터)
  private List<Map<Object , String>> boards = new ArrayList<>();
  
  // [1] POST
  @PostMapping("")
  // [POST] http://localhost:8080/day07/react
  // { "writer" : "유재석" , "content" : "안녕하세요" , "pwd" : "1234" }
  public boolean onPost(@RequestBody Map<Object , String> map) {
    System.out.println("RestController.onPost"); // south
    System.out.println("map = " + map); // soup
    boards.add(map); // 요청받은 데이터를 리스트에 저장
    return true;
  } // onPost end
  
  // [2] GET
  @GetMapping("")
  // [GET] http://localhost:8080/day07/react
  public List<Map<Object , String>> onFindAll() {
    System.out.println("RestController.onFindAll"); // south
    return boards;
  } // onFindAll end
} // RestController end
