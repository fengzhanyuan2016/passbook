package com.bmw.passbook.security;

import com.bmw.passbook.constant.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.var;

public class AuthCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        var token = request.getHeader(Constants.TOKEN_STRING);
        if(StringUtils.isEmpty(token)){
            throw new Exception("Header中缺少"+ Constants.TOKEN_STRING+"!");
        }
        if(token!=Constants.TOKEN ){
            throw new Exception("Header"+ Constants.TOKEN_STRING+ "错误!");
        }
        AccessContext.setToken(token);
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        AccessContext.clearAccessKey();
    }
}
