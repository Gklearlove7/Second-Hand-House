package com.gklearlove;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: GK
 * @Date: 2020/4/9 9:08
 */
@SpringBootApplication
@ComponentScan("com.gklearlove.*")
public class Application {
    public static void main(String[] args) {
        System.out.println("开始springboot起飞");
        SpringApplication.run(Application.class,args);
        System.out.println("已经启动了");
    }
}
