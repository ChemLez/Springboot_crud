package cn.lizhi.springboot_crud.service;

import cn.lizhi.springboot_crud.entity.Employee;
import cn.lizhi.springboot_crud.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper mapper;

    /**
     * 查询所有员工信息
     *
     * @return
     */
    public List<Employee> getAll() {
        List<Employee> employees = mapper.selectAll();
        return employees;
    }

    /**
     * 带部门信息的员工信息查询
     *
     * @return
     */
    public List<Employee> getAllWithDept() {
        Example example = new Example(Employee.class);
        example.setDistinct(true);
        example.orderBy("empId");
        List<Employee> employees = mapper.selectByOrderWithDept(example);
        return employees;
    }

    /**
     * 新增员工
     *
     * @param employee
     */
    public void saveEmp(Employee employee) {
        mapper.insert(employee);
    }

    /**
     * 员工姓名是否已经存在
     *
     * @param empName
     * @return
     */
    public Boolean isNotExist(String empName) {
        Example example = new Example(Employee.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("empName", empName);
        int i = mapper.selectCountByExample(example);
        if (i > 0) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * 单个员工信息的查询
     *
     * @param empId
     * @return
     */
    public Employee getOneById(Integer empId) {
        Example example = new Example(Employee.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("empId", empId);
        Employee employee = mapper.selectOneByExample(example);
        return employee;
    }

    /**
     * 员工信息更新
     *
     * @param employee
     */
    public void updateEmpById(Employee employee) {
        mapper.updateByPrimaryKeySelective(employee);
    }

    /**
     * 根据主键删除员工信息
     *
     * @param integer
     */
    public int deleteEmpById(Integer integer) {
        int i = mapper.deleteByPrimaryKey(integer);
        return i;
    }

    public int deleteBatchEmp(ArrayList<Integer> ids) {
        Example example = new Example(Employee.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("empId", ids);
        int i = mapper.deleteByExample(example);
        return i;
    }


    /**
     * 实现模糊查询;姓名、性别、部门
     * @param employee
     * @return
     */
    public List<Employee> getEmpByCondition(Employee employee) {
        List<Employee> employees = mapper.selectEmpByConditionWithDept(employee);
        return employees;
    }


}
