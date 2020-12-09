package cn.lizhi.springboot_crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
@tk.mybatis.spring.annotation.MapperScan(basePackages = "cn.lizhi.springboot_crud.mapper")
public class SpringbootCrudApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringbootCrudApplication.class, args);
//        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

    }


}
