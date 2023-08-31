package com.example.case_study_md3_demo.service.iplm;

import com.example.case_study_md3_demo.DAO.iplm.RoleDAO;
import com.example.case_study_md3_demo.model.Role;
import com.example.case_study_md3_demo.service.IRoleService;

import java.util.List;

public class RoleManage implements IRoleService {
    private final RoleDAO roleDAO;
    private static RoleManage roleManage;
    public RoleManage(){
        roleDAO = new RoleDAO();
    }
    public static RoleManage getRoleManage(){
        if (roleManage == null){
            roleManage = new RoleManage();
        }
        return roleManage;
    }

    @Override
    public List<Role> findAll() {
       return roleDAO.findAll();
    }

    @Override
    public Role findById(int id) {
        return roleDAO.findById(id);
    }

    @Override
    public void create(Role role) {
     roleDAO.create(role);
    }

    @Override
    public void update(Role role) {

    }
}
