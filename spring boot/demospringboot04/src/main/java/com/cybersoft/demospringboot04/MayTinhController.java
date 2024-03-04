package com.cybersoft.demospringboot04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/maytinh")
public class MayTinhController {
    @GetMapping("")
    public String mayTinh(@RequestParam int soA, @RequestParam int soB){
        int tong = soA + soB;
        System.out.println("Tổng " + "là: " + tong);
        return "hello";
    }
}
