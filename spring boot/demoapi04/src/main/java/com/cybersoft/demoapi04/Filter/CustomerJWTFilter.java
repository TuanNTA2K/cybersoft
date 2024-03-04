package com.cybersoft.demoapi04.Filter;

import com.cybersoft.demoapi04.Utils.JwtUtils;
import com.cybersoft.demoapi04.payload.response.RoleResponse;
import com.google.gson.Gson;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerJWTFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils jwtUtils;
    private final Gson gson = new Gson();
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String headerAuthen = request.getHeader("Authorization");
        if(headerAuthen != null && !headerAuthen.trim().isEmpty()){
            String token = headerAuthen.substring(7);
            //Giai ma token
            String data = jwtUtils.decryptToken(token);
            if(data != null){

                RoleResponse role = gson.fromJson(data, RoleResponse.class);
                System.out.println("Kiem tra jwt data "+ data +" " + role.getName());

                List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
                SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getName());
                authorityList.add(simpleGrantedAuthority);

                //Tao chung thuc cho security biet la da hop le va bypass dc tat ca cac filter cua security
                UsernamePasswordAuthenticationToken authen =
                        new UsernamePasswordAuthenticationToken("", "", new ArrayList<>());
                SecurityContext securityContext = SecurityContextHolder.getContext();
                securityContext.setAuthentication(authen);
            }
        }
        filterChain.doFilter(request, response);
    }
}
