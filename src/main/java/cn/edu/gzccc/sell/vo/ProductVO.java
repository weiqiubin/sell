package cn.edu.gzccc.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 次外层：商品包含类目(给resultVO用的)
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = -8636645524134728425L;

    /** 类目名称 */
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
