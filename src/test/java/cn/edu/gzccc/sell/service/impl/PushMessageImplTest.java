package cn.edu.gzccc.sell.service.impl;

import cn.edu.gzccc.sell.dto.OrderDTO;
import cn.edu.gzccc.sell.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageImplTest {

    @Autowired
    private PushMessageServiceImpl pushMessage;

    @Autowired
    private OrderService orderService;

    @Test
    public void orderStaltus() {
       OrderDTO orderDTO = orderService.findOne("1540612348699825468");

       pushMessage.orderStatus(orderDTO);
    }

}