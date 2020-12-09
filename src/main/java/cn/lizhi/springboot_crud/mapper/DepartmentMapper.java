package cn.lizhi.springboot_crud.mapper;

import cn.lizhi.springboot_crud.entity.Department;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface DepartmentMapper extends Mapper<Department> {
}