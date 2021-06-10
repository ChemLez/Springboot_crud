package cn.lizhi.springboot_crud.controller;

import cn.lizhi.springboot_crud.entity.Department;
import cn.lizhi.springboot_crud.entity.Employee;
import cn.lizhi.springboot_crud.entity.Msg;
import cn.lizhi.springboot_crud.service.DepartmentService;
import cn.lizhi.springboot_crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
//@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    /**
     * 无条件查询，返回给首页
     *
     * @return
     */
//    @RequestMapping("/emps")
    public Msg getAll(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 5);
        List<Employee> employees = employeeService.getAllWithDept();
        PageInfo page = new PageInfo(employees, 5); // 对employees进行分页的封装，查询页数为5页，分页栏中前后的页码显示5页
        List<Department> depts = departmentService.getDept();
        Msg msg = Msg.success().add("pages", page).add("departments", depts);

        return msg;
    }

    /**
     * 根据主键进行查询,单个用户。用于信息的回显
     *
     * @param empId
     * @return
     */
    @GetMapping(value = "/emp/{empId}")
    public Msg getOneEmp(@PathVariable("empId") Integer empId) {
        Employee employee = employeeService.getOneById(empId);
        List<Department> departments = departmentService.getDept();
        if (employee != null) {
            return Msg.success().add("employee", employee).add("department", departments);
        } else {
            return Msg.fail();
        }
    }

    /**
     * 用户更新
     *
     * @param employee
     * @param empId
     * @param result
     * @return
     */
    @PutMapping(value = "/emp/{empId}")
    public Msg updateEmp(@Valid Employee employee, @PathVariable("empId") Integer empId, BindingResult result) {
        employee.setEmpName(null);
        // 修改提交的信息进行后端验证；
        if (result.hasFieldErrors("email")) {
            HashMap<String, String> map = new HashMap<>();
            map.put(result.getFieldError("email").getField(), result.getFieldError("email").getDefaultMessage());
            return Msg.fail().add("errorFields", map);
        }
        employee.setEmpId(empId);
        employeeService.updateEmpById(employee);
        return Msg.success();
    }

    /**
     * 用户新增
     *
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public Msg saveEmp(@Valid Employee employee, BindingResult result) { // 后端校验
        HashMap<String, String> map;
        if (result.hasErrors()) { // 验证未通过
            map = new HashMap<>();
            List<FieldError> fieldErrors = result.getFieldErrors();// 获取所有错误信息的字段和message
            // 取出全部的错误信息
            for (FieldError fieldError : fieldErrors) {
                String error_message = fieldError.getDefaultMessage();
                String error_name = fieldError.getField();
                map.put(error_name, error_message);
            }
            return Msg.fail().add("errorFields", map);
        }

        if (employeeService.isNotExist(employee.getEmpName())) { // 验证通过
            employeeService.saveEmp(employee);
            return Msg.success();
        } else { // 用户名已经存在
            map = new HashMap<>();
            map.put("empName", "用户名已经存在");
            return Msg.fail().add("errorFields", map);
        }

    }

    /**
     * 判断用户名是否已经存在
     *
     * @param empName
     * @return
     */
    @RequestMapping("/isExistEmp")
    public Msg isEmp(@RequestParam("empName") String empName) {
        // 首先对用户名进行合法性判断
        String regx = "(^[a-z0-9_-]{3,16}$)|(^[\\u2E80-\\u9FFF]{2,5}$)";
        Boolean regx_flag = empName.matches(regx);
        if (!regx_flag) {
            return Msg.fail().add("msg", "请输入3-16位英文数字用户名或2-5位中文用户名_after");
        }
        Boolean flag = employeeService.isNotExist(empName);
        if (flag) {
            return Msg.success();
        } else {
            return Msg.fail().add("msg", "用户名已经存在after");
        }
    }

    /**
     * 根据id对employee进行删除
     *
     * @param integer
     * @return
     */
    @DeleteMapping("/emp/{id}")
    public Msg deleteEmpById(@PathVariable("id") Integer integer) {

        int i = employeeService.deleteEmpById(integer);
        if (i > 0) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    /**
     * 批量删除
     *
     * @param idString
     * @return
     */
    @DeleteMapping("/emp")
    public Msg deleteBatchEmp(@RequestParam("empIds") String idString) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        String[] ids = idString.split("-");
        for (String id : ids) {
            list.add(Integer.parseInt(id));
        }
        int i = employeeService.deleteBatchEmp(list);
        if (i > 0) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    /**
     * 条件查询 -- 适用于模糊查询
     * @param employee
     * @param pn
     * @return
     */
    @PostMapping("/conditionalEmp")
    public Msg getEmpByCondition(Employee employee, @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
//        System.out.println(employee);
        PageHelper.startPage(pn, 5);
        List<Employee> employees = employeeService.getEmpByCondition(employee);
        PageInfo<Employee> page = new PageInfo<>(employees, 5);
        List<Department> depts = departmentService.getDept();
        return Msg.success().add("pages", page).add("departments", depts);
    }
}
