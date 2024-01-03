package com.cybersoft.crm04.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import java.io.IOException;

public class CustomFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Kiem tra filter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        //Kiểm tra xem session lưu trữ ở login lúc đn thành công có tồn tại hay ko
        if(session != null && session.getAttribute("email") != null && !session.getAttribute("email").equals("")){
            //chuyển hướng về trang chủ
            response.sendRedirect("http://localhost:8080");
        }else{
            //      cho di tiep vao duong dan ma client dang goi
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }



    /*
    Nếu vào link là /role mà chưa đn thì sẽ chuyển về trang đn
     */
}
