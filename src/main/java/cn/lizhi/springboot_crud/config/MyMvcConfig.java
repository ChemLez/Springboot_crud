package cn.lizhi.springboot_crud.config;

import cn.lizhi.springboot_crud.component.LoginHandlerInterceptor;
import cn.lizhi.springboot_crud.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("index.html").setViewName("index");
        registry.addViewController("list.html").setViewName("emp/list");

    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()) // 设定过滤器规则
                .addPathPatterns("/**") // 过滤全部
                .excludePathPatterns("/","/index.html","/login","/asserts/**","/webjars/**"); // 排除首页、login登录方法以及静态资源的过滤
    }

}
