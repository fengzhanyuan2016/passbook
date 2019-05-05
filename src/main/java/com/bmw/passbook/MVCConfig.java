package com.bmw.passbook;


import com.bmw.passbook.security.AuthCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MVCConfig implements WebMvcConfigurer {

    private AuthCheckInterceptor _authCheckInterceptor;

    public MVCConfig(AuthCheckInterceptor authCheckInterceptor) {
        this._authCheckInterceptor = authCheckInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(_authCheckInterceptor).addPathPatterns("/api/**");
    }
}
