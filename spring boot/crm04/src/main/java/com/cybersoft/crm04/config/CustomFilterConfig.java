package com.cybersoft.crm04.config;

import com.cybersoft.crm04.filter.CustomFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomFilterConfig {

    //khia bao thong tin cau hinh cho filter
    @Bean
    public FilterRegistrationBean<CustomFilter> filterConfig(){
        FilterRegistrationBean<CustomFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CustomFilter());
        registrationBean.addUrlPatterns("/login");//khi user goi link /role moi kich hoat filter

        return registrationBean;
    }
}
/*
1)Nếu như đã đn rồi ko cần đn lại đá về trang chủ ko cho vô trang đn
-B1: khi đn thành công thì phải lưu lại thông tin user đn( Session/cookie)
-B2: khi user vào lại trang login thì kiểm tra xem Session/Cookie lưu trữ thông tin user có đang tồn tại ko. Nếu tồn tại
-B3: Nếu tồn tại chuyển hướng về page trang chủ
-B4: Nếu ko tồn tại thì đi vào trang login
2)Hãy thêm vào tính năng phân quyền cho hệ thống CRM
-Admin : crud role
* các bước làm:
  -
 */
