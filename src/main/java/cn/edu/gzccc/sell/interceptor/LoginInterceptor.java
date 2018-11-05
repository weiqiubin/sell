package cn.edu.gzccc.sell.interceptor;


import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if(!StringUtils.isEmpty(session.getAttribute("sellerInfo"))){
            return true;
        } else{
            response.sendRedirect("/sell/seller/login");
            return false;
        }

    }

}
