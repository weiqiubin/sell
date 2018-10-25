package cn.edu.gzccc.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        log.info("进入auth方法。。。");
        log.info("code={}", code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxa44dc0ce28b5d078&secret=4ddeda9b9cda16e70cf47f6660200f36&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);
        //https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxa44dc0ce28b5d078&redirect_uri=http://weiqiubin.natapp1.cc/sell/weixin/auth&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect
    }
}