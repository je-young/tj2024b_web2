package example.day07task.model.mapper;


import example.day07task.model.dto.TaskDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper // Mybatis Mapper 인터페이스 선언
public interface TaskMapper {
  
  @Insert("insert into phonebook(name, phone) values( #{name} , #{phone} )")
  boolean insertPhone(TaskDto taskDto);
  
  @Select("select * from phonebook")
  List<TaskDto> findAllPhones();
  
} // PhoneBookMapper end
