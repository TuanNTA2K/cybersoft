package com.cybersoft.crm04.config;

<<<<<<< HEAD
import com.cybersoft.crm04.filter.AdminFilter;
import com.cybersoft.crm04.filter.AuthenticationFilter;
=======
>>>>>>> origin/main
import com.cybersoft.crm04.filter.CustomFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomFilterConfig {

<<<<<<< HEAD
    //khai bao thong tin cau hinh cho filter
=======
    //khia bao thong tin cau hinh cho filter
>>>>>>> origin/main
    @Bean
    public FilterRegistrationBean<CustomFilter> filterConfig(){
        FilterRegistrationBean<CustomFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CustomFilter());
<<<<<<< HEAD
        registrationBean.addUrlPatterns("/login");//khi user goi link /login moi kich hoat filter
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<AuthenticationFilter> authenfilterConfig(){
        FilterRegistrationBean<AuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AuthenticationFilter());
        registrationBean.addUrlPatterns("/role");//khi user goi link /role moi kich hoat filter
        registrationBean.setOrder(2);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<AdminFilter> adminFilter(){
        FilterRegistrationBean<AdminFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AdminFilter());
        registrationBean.addUrlPatterns("/role");//khi user goi link /role moi kich hoat filter
        registrationBean.setOrder(3);
=======
        registrationBean.addUrlPatterns("/login");//khi user goi link /role moi kich hoat filter

>>>>>>> origin/main
        return registrationBean;
    }
}
/*
1)Nếu như đã đn rồi ko cần đn lại đá về trang chủ ko cho vô trang đn
-B1: khi đn thành công thì phải lưu lại thông tin user đn( Session/cookie)
<<<<<<< HEAD
-B2: khi user vào lại trang login thì kiểm tra xem Session/Cookie lưu trữ thông tin user có đang tồn tại ko.
=======
-B2: khi user vào lại trang login thì kiểm tra xem Session/Cookie lưu trữ thông tin user có đang tồn tại ko. Nếu tồn tại
>>>>>>> origin/main
-B3: Nếu tồn tại chuyển hướng về page trang chủ
-B4: Nếu ko tồn tại thì đi vào trang login
2)Hãy thêm vào tính năng phân quyền cho hệ thống CRM
-Admin : crud role
* các bước làm:
  -
 */
