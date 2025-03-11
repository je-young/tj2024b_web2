package example.day08.controller;


import example.day08.model.dto.ProductDto;
import example.day08.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 스프링 빈 등록
@RequestMapping("/day08/products") // 공통 URL : http://localhost:8080/day08/products
public class ProductController {
    // [1] 서비스 메소드를 사용하기 위한 객체 주입
    @Autowired private ProductService productService;

    // [2] 전체조회
    @GetMapping("") // (1) http://localhost:8080/day08/products
    public List<ProductDto> onRead() { // (2) 매개타입 구성 (Rest 명세서)
        // (3) 리턴타입 구성 (Rest 명세서)
        System.out.println("ProductController.onRead");
        return productService.onRaad(); // 샘플
    } // end onRead

    // [1] 제품등록
    @PostMapping("") // (1) http://localhost:8080/day08/products
    public boolean onCreate(@RequestBody ProductDto productDto) { // {"name" : "콜라" , "price" : "1300" , "comment" : "맛있는 코카콜라"}
        System.out.println("ProductController.onCreate");
        System.out.println("productDto = " + productDto);
        return productService.onCreate(productDto);
    } // end onCreate

    // [2] 제품수정
    @PutMapping("") // (1) http://localhost:8080/day08/products
    public boolean onUpdate(@RequestBody ProductDto productDto) { // {"id" : "1" , "name" : "콜라" , "price" : "1300" , "comment" : "맛있는 코카콜라"}
        System.out.println("ProductController.onUpdate");
        System.out.println("productDto = " + productDto);
        return productService.onUpdate(productDto);
    } // end onUpdate

} // end class
