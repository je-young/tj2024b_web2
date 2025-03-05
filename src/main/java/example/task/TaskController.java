package example.task;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;


/*
   과제 :
   1. TaskController 에서 TaskService 의 'method1' 메소드를 호출하는 방법
   2. 최소 6개 이상 방법 찾기
*/


@Controller
public class TaskController {
  
  // 1. 필드 주입 : @Autowired
  // 가장 간단한 방법. 스프링이 알아서 TaskService 빈을 주입
  @Autowired
  private TaskService taskService;
  
  public void callMethod1(){
    taskService.method1();
  }
  
  // 2. Setter 주입 : @Autowired
  // Setter 메소드를 통해 주입 받는 방법. 조금 더 유연하게 의존성을 병경 할 수 있음.
  @Autowired
  public void setTaskService(TaskService taskService){
    this.taskService = taskService;
  }
  
  public void callMethod2(){
    taskService.method1();
  }
  
  // 3. 생성자 주입 : @Autowired
  // 생성자 주입은 스프링 에서도 가장 권장하는 방법 불변성 보장
  @Autowired
  public TaskController(TaskService taskService){
    this.taskService = taskService;
  }
  
  public  void callMethod3(){
    taskService.method1();
  }
  
  // 4. @Resource 주입
  // 자바 표준 어노테이션인 @Resource 를 이용해서 의존성을 주입받는 방법
  @Resource
  private TaskService taskService;
  
  public void callMethod4(){
    taskService.method1();
  }
  
  // 5. @Inject 주입 : JSR-330
  // 또 다른 자바 표준 DI 어노테이션인 @Inject 를 사용.
  @Inject
  private TaskService taskService;
  
  public  void callMethod5(){
    taskService.method1();
  }
  
  // 6. 직접 인스턴스 생성 : new 연산자
  // 스프링의 DI 를 우회하는 방법으로, 직접 객체를 생성할 수도 있음. (비추천 : 스프링의 장점을 살리지 못함)
  public  void callMethod6(){
    TaskService taskService = new TaskService(); // 직접 생성!
    taskService.method1();
  }
  
  // 7. ApplicationContext 를 통한 조회
  // 스프링 컨테이너 에서 직접 빈을 조회 하는 방법
  public void callMethod7(){
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    TaskService taskService = context.getBean(TaskService.class);
    taskService.method1();
  }

} // TaskController end


