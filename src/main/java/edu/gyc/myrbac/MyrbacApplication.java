package edu.gyc.myrbac;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("edu.gyc.myrbac.dao")
@SpringBootApplication
public class MyrbacApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyrbacApplication.class, args);
    }

}
