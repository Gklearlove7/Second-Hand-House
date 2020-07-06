package com.gklearlove.config;

import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

/**
 * @Author: GK
 * @Date: 2020/5/13 17:09
 */
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        String k = request.getServletPath();
        String type = request.getHeader("X-Requested-With");// XMLHttpRequest
            if (user == null) {
                // 重定向
                String path = request.getContextPath();
//                String basePath = "http://121.199.42.126:8081/user/";

                //演示使用的重定向地址
                String basePath = "http://localhost:8081/user/";


                //response.sendRedirect(contextPath+"/index.jsp");
                // System.err.println("sendRedirect");
                // 转发
                if (StringUtils.equals("XMLHttpRequest", type)) {
                    // ajax请求
                    response.setHeader("SESSIONSTATUS", "TIMEOUT");
                    response.setHeader("CONTEXTPATH", basePath+"gologin");
//                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);//403 禁止
                    return false;
                } else {
                    response.sendRedirect(basePath+"gologin");
                    return false;
                }
            }else {
                return true;
            }
        }

}
