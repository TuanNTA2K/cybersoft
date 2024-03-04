package com.cybersoft.demoapi04.controller;

import com.cybersoft.demoapi04.payload.response.BaseResponse;
import com.cybersoft.demoapi04.service.imp.LoginServiceImp;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;

@RestController
@RequestMapping("/login")
public class LoginController {

    /**
     * Do password lưu trữ trong database là chuỗi mã hóa dạng BCrypt cho nên không thể dùng password như
     * điều kiện WHERE
     *
     * Bước 1 : Viết câu truy vấn lấy dữ liệu đăng nhập dựa trên username
     * Bước 2 : Lấy dữ liệu password trả ra từ bước 1 và kiểm tra xem password lưu trữ trong database với password
     * người dùng tryền lên.
     * Bước 3 : Nếu 2 mật khẩu match thì sẽ tạo ra token, nếu không giống thì báo đăng nhập thất bại
     *   - Tạo ra key để mã hóa và giải mã
     */

    @Autowired
    private LoginServiceImp loginServiceImp;

    @PostMapping("")            //                                  123456
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password){

        String token = loginServiceImp.checkLogin(username,password);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(token);


        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

}
