package cn.edu.gzccc.sell.repository;

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
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = productCategoryRepository.findOne(1);
        System.out.println(productCategory.toString());
        System.out.println(productCategory.getCategoryName());
    }

    @Test
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(3);
        productCategoryRepository.save(productCategory);
        System.out.println("测试成功");
    }
    @Test
    public void updateTest(){
        ProductCategory productCategory = productCategoryRepository.findOne(2);
        productCategory.setCategoryName("中生最爱");
        productCategory.setCategoryType(10);
        productCategoryRepository.save(productCategory);
        System.out.println("测试成功");
    }

    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result = productCategoryRepository.findByCategoryTypeIn(list);
        System.out.println(result.size());
        Assert.assertNotEquals(0,result.size());
    }



}