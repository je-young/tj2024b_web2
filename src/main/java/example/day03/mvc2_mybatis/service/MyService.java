package example.day03.mvc2_mybatis.service;


import example.day03.mvc2_mybatis.model.dto.MyDto;
import example.day03.mvc2_mybatis.model.mapper.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {

    @Autowired private MyMapper myMapper;
    // [1] 등록 로직
    public int save(MyDto myDto){
        System.out.println("MyService.save");
        System.out.println("myDto = " + myDto);
        // 서비스는 mapper 인터페이스 요청하고 응답받는다.
        int result = myMapper.save(myDto);
        return result;
    } // save end
    // [2] 전체 조회 로직
    public List<MyDto> findall(){
        System.out.println("MyService.findall");
        List<MyDto> result = myMapper.findall();
        return result;
    } // findall end
    // [3] 개별 조회 로직
    public MyDto find(int id){
        System.out.println("MyService.find");
        System.out.println("id = " + id);
        MyDto result = myMapper.find(id);
        return result;
    } // find end
    // [4] 수정 로직
    public int update(MyDto myDto){
        System.out.println("MyService.update");
        System.out.println("myDto = " + myDto);
        int result = myMapper.update(myDto);
        return result;
    } // update end
    // [5] 개별 삭제 로직
    public int delete(int id){
        System.out.println("MyService.delete");
        System.out.println("id = " + id);
        int result = myMapper.delete(id);
        return result;
    } // delete end

} // MyService end
