package cn.lizhi.springboot_crud.service;

import cn.lizhi.springboot_crud.entity.Admin;
import cn.lizhi.springboot_crud.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {


    @Autowired
    private AdminMapper mapper;

    public Admin login(String username, String password) {
        Admin admin = new Admin(username, password);
        Admin loginAdmin = mapper.selectOne(admin);
        return loginAdmin;
    }



}
