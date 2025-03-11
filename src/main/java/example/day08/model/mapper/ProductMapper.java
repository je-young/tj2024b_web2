package example.day08.model.mapper;


import example.day08.model.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("select * from productsample")
    public List<ProductDto> onRaad();
} // end interface
