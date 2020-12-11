package cn.lizhi.springboot_crud.mapper;

import cn.lizhi.springboot_crud.entity.Employee;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Repository
public interface EmployeeMapper extends Mapper<Employee> {

    List<Employee> selectByOrderWithDept(Example example);

    List<Employee> selectEmpByConditionWithDept(Employee employee);
}