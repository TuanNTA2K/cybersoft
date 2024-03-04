package com.cybersoft.demoapi04.service;

import com.cybersoft.demoapi04.entity.UsersEntity;
import com.cybersoft.demoapi04.payload.response.RoleResponse;
import com.cybersoft.demoapi04.repository.UsersRepository;
import com.cybersoft.demoapi04.service.imp.LoginServiceImp;
import com.cybersoft.demoapi04.utils.JwtUltils;
import com.google.gson.Gson;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class LoginService implements LoginServiceImp {


    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUltils jwtUltils;

    private Gson gson = new Gson();

    @Override
    public String checkLogin(String username, String password) {
        String token = "";
        UsersEntity usersEntity = usersRepository.findByEmail(username);
        if(passwordEncoder.matches(password, usersEntity.getPassword()) ){
            //Tạo token từ key đã sinh ra và lưu trữ trước đó
            RoleResponse roleResponse = new RoleResponse();
            roleResponse.setName(usersEntity.getRole().getName());

            String roles = gson.toJson(roleResponse);
            token = jwtUltils.createToken(roles);
        }

        return token;
    }
}
