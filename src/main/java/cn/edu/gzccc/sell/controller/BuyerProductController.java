package cn.edu.gzccc.sell.controller;

import cn.edu.gzccc.sell.dataobject.ProductCategory;
import cn.edu.gzccc.sell.dataobject.ProductInfo;
import cn.edu.gzccc.sell.service.impl.CategoryServiceImpl;
import cn.edu.gzccc.sell.service.impl.ProductserviceImpl;
import cn.edu.gzccc.sell.utils.ResultVOUtil;
import cn.edu.gzccc.sell.vo.ProductInfoVO;
import cn.edu.gzccc.sell.vo.ProductVO;
import cn.edu.gzccc.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *买家商品
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductserviceImpl productservice;

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("list")
    public ResultVO list(){

        //1.查询所有上架商品
        List<ProductInfo> productInfoList = productservice.findUpAll();

        //2.c查询类目（一次性查询）
        List<Integer> categoryTypeList = new ArrayList<>();
        for (ProductInfo productInfo : productInfoList){
            categoryTypeList.add(productInfo.getCategoryType());
        }
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼装,用第一，第二步中查询到的数据set给VO,利用VO对象放回给前端
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList){
                ProductVO productVO = new ProductVO();
                productVO.setCategoryName(productCategory.getCategoryName());
                productVO.setCategoryType(productCategory.getCategoryType());
                //构造ProductInfoVOList
                List<ProductInfoVO> productInfoVOList = new ArrayList<>();
                for (ProductInfo productInfo: productInfoList) {
                    if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                        ProductInfoVO productInfoVO = new ProductInfoVO();
                        //复制
                        BeanUtils.copyProperties(productInfo, productInfoVO);
                        productInfoVOList.add(productInfoVO);
                    }
                }
                productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
