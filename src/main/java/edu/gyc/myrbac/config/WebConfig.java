package edu.gyc.myrbac.config;


import edu.gyc.myrbac.interceptor.PermissionHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public PermissionHandlerInterceptor myPermissionInterceptor() {
        System.out.println("new PermissionHandlerInterceptor");
       return  new PermissionHandlerInterceptor();
    }


    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myPermissionInterceptor())
                .addPathPatterns("/api/**");

    }

}
