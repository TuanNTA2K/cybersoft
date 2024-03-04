package com.cybersoft.crm04.config;

import com.cybersoft.crm04.filter.CustomFilterRole;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigFilterRoleAdd {
    @Bean
    public FilterRegistrationBean<CustomFilterRole> filterRoleAdd(){
        FilterRegistrationBean<CustomFilterRole> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CustomFilterRole());
        registrationBean.addUrlPatterns("/role/add");
        return registrationBean;
    }
}
