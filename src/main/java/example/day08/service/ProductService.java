package example.day08.service;

import example.day08.model.dto.ProductDto;
import example.day08.model.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 스프링 빈 등록
public class ProductService {

    @Autowired private ProductMapper productMapper;

    // [2] 전체조회
    public List<ProductDto> onRaad() {
        System.out.println("ProductService.onRaad");
        return productMapper.onRaad();
    } // end onRaad

    // [1] 제품등록
    public boolean onCreate(ProductDto productDto) {
        return productMapper.onCreate(productDto);
    } // end onCreate

    // [3] 제품수정
    public boolean onUpdate(ProductDto productDto) {
        System.out.println("ProductService.onUpdate");
        System.out.println("productDto = " + productDto);
        return productMapper.onUpdate(productDto);
    }

} // end class
