package com.cybersoft.demoapi04.service;

import com.cybersoft.demoapi04.entity.RolesEntity;
import com.cybersoft.demoapi04.repository.RolesRepository;
import com.cybersoft.demoapi04.service.imp.RoleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements RoleServiceImp {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public List<RolesEntity> getAllRole() {

        return rolesRepository.findAll();
    }

    @Override
    public boolean deleteRoleById(int id) {
        boolean isDelete = false;
        try{
            rolesRepository.deleteById(id);
            isDelete = true;
        }catch (Exception e){
            System.out.println("Loi xoa role " + e.getMessage());
        }

        return isDelete;
    }
}
