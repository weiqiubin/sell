package cn.edu.gzccc.sell.service.impl;

import cn.edu.gzccc.sell.dataobject.SellerInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest {

    private static final String openid = "abc";

    @Autowired
    private SellerServiceImpl sellerService;

    @Test
    public void findUsernameandPassword() {
        SellerInfo sellerInfo = sellerService.findByUsernameAndPassword("admin","admin");
        Assert.assertEquals("admin",sellerInfo.getUsername());
    }
}