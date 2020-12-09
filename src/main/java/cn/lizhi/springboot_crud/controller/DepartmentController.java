package cn.lizhi.springboot_crud.controller;

import cn.lizhi.springboot_crud.entity.Department;
import cn.lizhi.springboot_crud.entity.Msg;
import cn.lizhi.springboot_crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/deps")
    public Msg getDepts() {

        List<Department> dept = departmentService.getDept();
        return Msg.success().add("departments", dept);
    }


}
