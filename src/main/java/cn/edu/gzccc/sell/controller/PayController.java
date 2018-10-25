package cn.edu.gzccc.sell.controller;

import cn.edu.gzccc.sell.dto.OrderDTO;
import cn.edu.gzccc.sell.enums.ResultEnum;
import cn.edu.gzccc.sell.exception.SellException;
import cn.edu.gzccc.sell.service.OrderService;
import cn.edu.gzccc.sell.service.PayService;
import cn.edu.gzccc.sell.utils.ResultVOUtil;
import com.lly835.bestpay.model.PayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String, Object> map) {
        //1. 查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        System.out.println(orderDTO.getBuyerOpenid());


        if (orderDTO.getBuyerOpenid() == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

/*       //2. 发起支付
        PayResponse payResponse = payService.create(orderDTO);

        map.put("payResponse", payResponse);*/
        map.put("returnUrl", returnUrl);


        return new ModelAndView("pay/create", map);
    }

    /**
     * 微信异步通知
     * @param notifyData
     */
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData) {
        payService.notify(notifyData);

        //返回给微信处理结果
        return new ModelAndView("pay/success");
    }
}