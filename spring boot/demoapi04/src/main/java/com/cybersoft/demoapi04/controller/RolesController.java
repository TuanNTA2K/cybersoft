package com.cybersoft.demoapi04.controller;

import com.cybersoft.demoapi04.entity.RolesEntity;
import com.cybersoft.demoapi04.payload.response.BaseResponse;
import com.cybersoft.demoapi04.service.RoleService;
import com.cybersoft.demoapi04.service.imp.RoleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RolesController {

    @Autowired
    private RoleServiceImp roleServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getRole(){
        List<RolesEntity> listRole = roleServiceImp.getAllRole();

        return new ResponseEntity<>(listRole, HttpStatus.OK);
    }

    //Viết API Xóa role với tham số nhận vào là role_id
    /**
     *   {
     *       "statusCode": 200,
     *       "message":"",
     *       "data": false|true
     *   }
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable int id){

        boolean isSuccess = roleServiceImp.deleteRoleById(id);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage(isSuccess ? "Thanh cong" : "That bai");
        baseResponse.setData(isSuccess);

        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
    }

}
