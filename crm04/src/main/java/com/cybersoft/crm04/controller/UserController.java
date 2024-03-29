package com.cybersoft.crm04.controller;

import com.cybersoft.crm04.entity.RolesEntity;
import com.cybersoft.crm04.entity.UsersEntity;
import com.cybersoft.crm04.service.RoleService;
import com.cybersoft.crm04.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/add")
    public String userAdd(Model model){
        List<RolesEntity> listRole = roleService.getAllRole();
        model.addAttribute("listRole",listRole);
        return"user-add";
    }
    @PostMapping("/add")
    public String processAdd(@RequestParam String fullname,
                             @RequestParam String email,
                             @RequestParam String password,
                             @RequestParam String phoneNumber,
                             @RequestParam("selectedRoleId") int roleId,
                             Model model,
                             @ModelAttribute UsersEntity user,
                             @RequestParam("fileImage") MultipartFile file) {

        RolesEntity rolesEntity = roleService.getRoleId(roleId);
        boolean insertUser = userService.insertUser(fullname, email, password, phoneNumber,file ,rolesEntity);
        model.addAttribute("insertUser",insertUser);
        UsersEntity usersEntity = new UsersEntity();
        model.addAttribute("fullname",fullname);
        model.addAttribute("email",email);
        model.addAttribute("password",password);
        model.addAttribute("phoneNumber",phoneNumber);
        List<RolesEntity> listRole = roleService.getAllRole();
        model.addAttribute("listRole",listRole);
        return"user-add";
    }
//    TODO: delete user
    @GetMapping("/delete/{user_id}")
    public String  deleteItem(@PathVariable(name = "user_id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/user/table"; // Chuyển hướng người dùng về trang role-table.html sau khi xóa thành công
    }
//  Show table user
    @GetMapping("/table")
    public String userTable(Model model){
        List<UsersEntity> listUser = userService.getAllUser();
        model.addAttribute("listUser",listUser);
        return "user-table";
    }
// Update user after edit
    @GetMapping("/update/{user_id}")
    public String update(@PathVariable(name = "user_id") int id, Model model){
        UsersEntity usersEntity = userService.getUserId(id);
        model.addAttribute("usersEntity",usersEntity);
        List<RolesEntity> listRole = roleService.getAllRole();
        model.addAttribute("listRole",listRole);
        return "user-update";
    }
    @PostMapping("/update/{user_id}")
    public String processUpdate(@PathVariable(name = "user_id") int user_id,
                                @RequestParam String fullname,
                                @RequestParam String email,
                                @RequestParam String password,
                                @RequestParam String phoneNumber,
                                @RequestParam("selectedRoleId") int roleId,
                                Model model){
        RolesEntity rolesEntity = roleService.getRoleId(roleId);
        boolean insertUser = userService.processUpdate(fullname, email, password,user_id, phoneNumber, rolesEntity);
        model.addAttribute("insertUser",insertUser);
        UsersEntity usersEntity = new UsersEntity();
        model.addAttribute("fullname",fullname);
        model.addAttribute("email",email);
        model.addAttribute("password",password);
        model.addAttribute("phoneNumber",phoneNumber);
        List<RolesEntity> listRole = roleService.getAllRole();
        model.addAttribute("listRole",listRole);
        return "redirect:/user/table";
    }
//  Show user details.
    @GetMapping("/details/{user_id}")
    public String userDetails(@PathVariable(name = "user_id") int id, Model model){
        List<UsersEntity> listUser = userService.getAllUser();
        model.addAttribute("listUser",listUser);
        return "user-details";
    }
}

