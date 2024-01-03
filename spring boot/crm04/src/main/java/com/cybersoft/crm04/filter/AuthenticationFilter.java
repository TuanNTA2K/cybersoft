package com.cybersoft.crm04.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Kiểm tra authen filter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        //Kiểm tra xem session lưu trữ ở login lúc đn thành công có tồn tại hay ko
        if(session != null && session.getAttribute("email") != null && !session.getAttribute("email").equals("")){
            //đăng nhập thành công
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            response.sendRedirect("http://localhost:8080/login");
        }
    }
}
