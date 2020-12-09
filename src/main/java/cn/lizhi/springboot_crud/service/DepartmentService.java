package cn.lizhi.springboot_crud.service;

import cn.lizhi.springboot_crud.entity.Department;
import cn.lizhi.springboot_crud.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getDept() {
        List<Department> departments = departmentMapper.selectAll();
        return departments;
    }
}
