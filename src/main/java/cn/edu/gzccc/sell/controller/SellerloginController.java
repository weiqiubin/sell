package cn.edu.gzccc.sell.controller;

import cn.edu.gzccc.sell.dataobject.SellerInfo;
import cn.edu.gzccc.sell.enums.ResultEnum;
import cn.edu.gzccc.sell.form.SellerLoginForm;
import cn.edu.gzccc.sell.service.impl.SellerServiceImpl;
import com.lly835.bestpay.rest.type.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/seller")
public class SellerloginController {

    @Autowired
    private SellerServiceImpl sellerService;

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("common/login");
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid SellerLoginForm sellerLoginForm,
                              BindingResult bindingResult,
                              Map<String,Object> map,
                              HttpSession httpSession){
        if (bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
        }

        SellerInfo sellerInfo = sellerService.findByUsernameAndPassword(
                                 sellerLoginForm.getUsername(),sellerLoginForm.getPassword());
            httpSession.setAttribute("sellerInfo",sellerInfo);
        if (sellerInfo!=null){
            return new ModelAndView("redirect:/seller/order/list");
        }else {
            map.put("msg", ResultEnum.LOGIN_USERNAME_PASSWORD.getMessage());
            return new ModelAndView("common/login",map);

        }

    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession httpSession){
        httpSession.removeAttribute("sellerInfo");
        return new ModelAndView("redirect:/seller/login");
    }
}
