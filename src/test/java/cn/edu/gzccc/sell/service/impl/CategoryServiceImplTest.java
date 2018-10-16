package cn.edu.gzccc.sell.service.impl;

import cn.edu.gzccc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> list = categoryService.findAll();
        for (ProductCategory productCategory : list){
            System.out.println(productCategory.getCategoryName());
        }

    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> integerList = Arrays.asList(1,2,3);
        List<ProductCategory> list = categoryService.findByCategoryTypeIn(integerList);
        for (ProductCategory productCategory : list) {
            System.out.println(productCategory.getCategoryName());
        }
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("我最爱",2);
        categoryService.save(productCategory);
    }
}