package example.day07task.controller;


import example.day07task.model.dto.TaskDto;
import example.day07task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day07/task")
@CrossOrigin("http://localhost:5173") // CORS 정책허용
public class TaskController {
  
  @Autowired
  TaskService taskService;
  
  // [1] POST
  @PostMapping("")
  // [POST] http://localhost:8080/day07/task
  // { "name" : "유재석" , "phone" : "010-1234-5678" }
  public boolean onPost(@RequestBody TaskDto taskDto) {
    System.out.println("taskDto = " + taskDto); // soutp
    return taskService.savePhone(taskDto);
  } // onPost end
  
  // [2] GET
  @GetMapping("")
  // [GET] http://localhost:8080/day07/task
  public List<TaskDto> onFindAll() {
    System.out.println("RestController.onFindAll"); // soutm
    return taskService.getAllPhones();
  } // onFindAll end
} // RestController end
