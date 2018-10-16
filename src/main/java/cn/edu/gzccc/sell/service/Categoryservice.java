package cn.edu.gzccc.sell.service;

import cn.edu.gzccc.sell.dataobject.ProductCategory;

import java.util.List;

public interface Categoryservice  {

    ProductCategory findOne(Integer categoryid);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
