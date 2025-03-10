package example.day07task.service;

import example.day07task.model.dto.TaskDto;
import example.day07task.model.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
  
  @Autowired
  TaskMapper taskMapper;
  
  // 1. 저장 기능
  public boolean savePhone(TaskDto taskDto){
    return taskMapper.insertPhone(taskDto);
  } // savePhone() end
  
  // 2. 전체 출력 기능
  public List<TaskDto> getAllPhones(){
    return taskMapper.findAllPhones();
  } // getAllPhones() end
} // TaskService end