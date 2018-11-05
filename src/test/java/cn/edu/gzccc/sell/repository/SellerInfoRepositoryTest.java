package cn.edu.gzccc.sell.repository;

import cn.edu.gzccc.sell.dataobject.SellerInfo;
import cn.edu.gzccc.sell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Test
    public void saveTest(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("abc");

        SellerInfo result = sellerInfoRepository.save(sellerInfo);
        Assert.assertNotNull(result);
     }

     @Test
    public void findByusernameAndpasswordTest(){
        SellerInfo sellerInfo = sellerInfoRepository.findByUsernameAndPassword("admin","admin");
        Assert.assertEquals("admin",sellerInfo.getUsername());
    }
}