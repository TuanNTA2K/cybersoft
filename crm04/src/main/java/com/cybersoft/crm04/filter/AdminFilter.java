package com.cybersoft.crm04.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        // Check if the user has the admin role (role_id equals 1)
        if (session != null && session.getAttribute("email") != null && session.getAttribute("role_id").equals(1)) {
            // User has admin role, allow access to the requested resource
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // User doesn't have admin role, redirect to 404 page
            response.sendRedirect("http://localhost:8080/404");
        }
        assert session != null;
        System.out.println("Role in session: " + session.getAttribute("role_id"));
    }

    // Other methods of the Filter interface (init and destroy) may be implemented here if needed
}
