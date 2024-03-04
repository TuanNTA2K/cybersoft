package com.cybersoft.demoapi04.service.imp;

import com.cybersoft.demoapi04.entity.RolesEntity;

import java.util.List;

public interface RoleServiceImp {
    List<RolesEntity> getAllRole();
    boolean deleteRoleById(int id);
}
