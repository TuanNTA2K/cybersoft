package com.cybersoft.demospringboot04.config;

import com.cybersoft.demospringboot04.entity.DemoEntity;
import com.cybersoft.demospringboot04.entity.EmployeesEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //Dùng để spring boot chạy các code trong class này khi spring boot chạy cấu hình
               //ở tầng config
public class DemoBeanConfig {
    //EL : Expression language
    @Value("${demo.config.name}")
    private String name;

    @Bean
    // @Primary: khi có 2 @Bean mà trùng tên đc lưu trữ trên IOC thì sẽ lấy thằng này làm mặc định
    public DemoEntity createDemoEntity(){
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setName(name);
        demoEntity.setId(1);

        return demoEntity;
    }

    @Bean
    public EmployeesEntity createEmployee(DemoEntity demo){

        EmployeesEntity employeesEntity = new EmployeesEntity();
        employeesEntity.setEmployeeName("Le thi C");
        System.out.println("Kiểm tra bean "+ demo.getName());
        return employeesEntity;
    }

//    @Bean(name = "demo2")
//    public DemoEntity createDemoEntity2(){
//        DemoEntity demoEntity = new DemoEntity();
//        demoEntity.setName("Trần Văn B");
//        demoEntity.setId(2);
//
//        return demoEntity;
//    }
}
