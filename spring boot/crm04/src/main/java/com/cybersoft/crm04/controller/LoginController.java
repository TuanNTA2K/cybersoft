package com.cybersoft.crm04.controller;

import com.cybersoft.crm04.entity.UsersEntity;
import com.cybersoft.crm04.repository.UsersRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/*
    Các bước cần làm cho 1 chức năng trong ứng dụng
    B1: Phân tích yêu cầu của chức năng, tức là phân tích cức năng đó mình cần làm gì và kết quả mong muốn
    B2: Xác định đc câu truy vấn( query ) dành cho chức năng đó
    B3: Từ câu query sẽ xác định đc đường dẫn có nhận tham số hay ko và số lượng tham số là bao nhiêu

 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsersRepository usersRepository;
    @GetMapping("")
    public String Login(HttpServletRequest request, Model model) {
//        List<UsersEntity> list = usersRepository.findByEmailAndPassword("nguyenvana@gmail.com", "123456");
//        for (UsersEntity item : list) {
//            System.out.println("Kiểm tra " + item.getEmail());
//        }

        Cookie[] cookies = request.getCookies();
        String email = "";
        String password = "";
        //A,B, email, password
        if(cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies
            ) {
                if (cookie.getName().equals("email")) {
                    email = cookie.getValue();
                }
                if (cookie.getName().equals("password")) {
                    password = cookie.getValue();
                }
            }
        }
        model.addAttribute("email", email);
        model.addAttribute("password", password);
        return "login";
    }

    //Controller : Nơi định nghĩa link
    //Model: cho phép trả giá trị từ java ra file Html
    //View: Chính là file html
    @PostMapping("")
    public String progressLogin(HttpSession httpSession,HttpServletResponse response, RedirectAttributes redirectAttributes, Model model, @RequestParam String email, @RequestParam String password) {
        /*
        Hoàn thiện chức năng login:
        B1: Thế tham số người dùng truyền vào hàm findByEmailAndPassword
            _Làm thế nào lấy đc tham số
            _Bên html làm cách nào để có thể gọi đc link /login với phương thức post
            _Làm cách nào truyền email và password
        B2: Kiểm tra xem list có dữ liệu hay ko?
        B3: Nếu có thì trả ra chuyển qua trang dashboard( Lưu tạo link /dashboard sử dụng page index.html)
        B4: Nếu thất bại thì xuất thông báo "Đăng nhập thất bại" ra màn hình login
            _Làm cách nào để trả giá trị của biến trong java ra file html
            _Làm cách nào để lấy đc giá trị
        *Lưu ý: Phương thức post => Chỉnh form data bên giao diện Login
         */
        List<UsersEntity> listUser = usersRepository.findByEmailAndPassword(email, password);
        boolean isSuccess = !listUser.isEmpty();

        //Kiểm tra xem danh sách users có giá trị ko?
        Cookie cookieEmail = null;
        if (isSuccess) {
            //Có giá trị => đăng nhập thành công
            redirectAttributes.addFlashAttribute("isSuccess", true);
            httpSession.setAttribute("email",email);
            httpSession.setMaxInactiveInterval(8*60*60);
//            cookieEmail = new Cookie("email", email);
//            Cookie cookiePassword = new Cookie("password", password);
//            response.addCookie(cookieEmail);
//            response.addCookie(cookiePassword);
            return "redirect:/index";
        } else {
            //Ko có giá trị => đăng nhập thất bại
            redirectAttributes.addFlashAttribute("isSuccess", false);
            return "redirect:/login";
        }
        //Đẩy giá trị của biến isSuccess ra file html và đặt tên key (biến) là isSuccess
        //model.addAttribute("isSuccess", isSusccess);
        //System.out.println("Kiểm tra: "+ email + " "+ password);
        //return "login";
    }
//    @GetMapping("/index")
//    public String showIndexPage() {
//        return "index";
//    }

    /*
    Khi đn thành công thì lưu email và mk vào cookie
    Khi user vô lại link /login thì sẽ điền sẵn email và mk vào input
    */

}
