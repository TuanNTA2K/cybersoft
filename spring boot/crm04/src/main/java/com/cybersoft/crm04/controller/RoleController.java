package com.cybersoft.crm04.controller;

import com.cybersoft.crm04.entity.RolesEntity;
import com.cybersoft.crm04.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/role")
public class RoleController {
    /*
    B1: X/đ nghiệp vụ cho chức năng
    B2: X/đ câu truy vấn
    B3: X/đ số lượng tham số sẽ sử dụng cho controller( đường dẫn đã khai báo)
        -- Xử lý nghiệp vụ thông qua code
    B4: Để thực hiện đc các query lq tới bảng đã đc x/đ ở b2 =>  tạo ra repository
        để quản lý các query nếu chưa có
    B5: X/đ hàm tương ứng với lại câu query b2 của JPA
     */
    @Autowired
    private RolesRepository rolesRepository;
    /*
        save(): có 2 function vừa là add data vừa là update data
            _add : khóa chính class Entity truyền vào hàm save() ko có giá trị
            _update : class Entity truyền vào hàm save() có giá trị
     */
    @GetMapping("")
    public String add(){
//        RolesEntity rolesEntity = new RolesEntity();
//        rolesEntity.setId(4);
//        rolesEntity.setName("ROLE_TEST");
//        rolesEntity.setDescription("Hello Test");

//        rolesRepository.save(rolesEntity);
        return "role-add.html";
    }

    @PostMapping("")
    public String processAdd(@RequestParam String roleName, @RequestParam String desc, Model model, RedirectAttributes redirectAttributes){

        RolesEntity rolesEntity = new RolesEntity();
        rolesEntity.setName(roleName);
        rolesEntity.setDescription(desc);
        try {
            rolesRepository.save(rolesEntity);
            redirectAttributes.addFlashAttribute("isSuccess", true);
        } catch (Exception e) {
            System.out.println("Lỗi thêm data" + e.getMessage());
            redirectAttributes.addFlashAttribute("isSuccess", false);
        }
        /* BTVN
        _ chỉnh link /role thành /role/add: fix lỗi liên quan đến css và js bên file html
        _ Nếu thêm role thành công thì phải xuất ra màn hình thông báo "thêm thành công" ngược lại "thêm thất bại"
         */
        return "redirect:/role";
    }
}
