package dto;

import lombok.Data;

/**
 * 购物车，前端->CartDTO->productService
 */

@Data
public class CartDTO {

    /** 商品ID */
    private String productId;

    /** 商品数量 */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
