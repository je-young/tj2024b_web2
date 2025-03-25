package example.day11._스프링스케줄링._과제1;


import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface TaskMapper {

    // 모든 상품 재고 3씩 감소
    @Update("UPDATE day11products SET stock_quantity = stock_quantity - 3")
    void decreaseAllStocks();

    // 전체 상품 조회
    @Select("SELECT product_id AS productId, product_name AS productName, stock_quantity AS stockQuantity FROM day11products")
    List<Product> findAllProducts();

    // 재고 10개 이하인 상품 20개 보충
    @Update("UPDATE day11products SET stock_quantity = stock_quantity + 20 WHERE stock_quantity <= 10")
    int restoreStockForLowInventory();
} // end TaskMapper

// 상품 도메인 클래스 (매퍼 내부에 중첩 클래스로 정의)
@Data
class Product {
    private Integer productId;
    private String productName;
    private Integer stockQuantity;

//    // Getters & Setters
//    public Integer getProductId() { return productId; }
//    public void setProductId(Integer productId) { this.productId = productId; }
//    public String getProductName() { return productName; }
//    public void setProductName(String productName) { this.productName = productName; }
//    public Integer getStockQuantity() { return stockQuantity; }
//    public void setStockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; }

    @Override
    public String toString() {
        return String.format(
                "ID: %d, 제품명: %-12s, 재고: %2d",
                productId, productName, stockQuantity
        );
    }
} // end Product
