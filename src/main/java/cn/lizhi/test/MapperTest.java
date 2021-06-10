package cn.lizhi.test;


import cn.lizhi.springboot_crud.SpringbootCrudApplication;
import cn.lizhi.springboot_crud.entity.Employee;
import cn.lizhi.springboot_crud.mapper.DepartmentMapper;
import cn.lizhi.springboot_crud.mapper.EmployeeMapper;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootCrudApplication.class)
public class MapperTest {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private SqlSession session;

    @Autowired
    private SqlSessionFactory sessionFactory;

    @Test
    public void testCRUD() {

//        employeeMapper.insert(new Employee(null, "Jerry", "M", "Jerry@163.com", 1));
        for (int i = 0; i < 1000; ++i) { // 随机生成1000条用户数据插入到数据库中
            String name = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5); // 作为名字的生成
            int id = Math.random() > 0.5 ? 1 : 2;
            String gender = Math.random() > 0.5 ? "M" : "F";
            employeeMapper.insert(new Employee(null, name, gender, name + "@163.com", id));
        }
        System.out.println("批量插入完毕");
    }

    @Test
    public void getApplication() {
        System.out.println(session);
        Configuration configuration = session.getConfiguration();
        Connection connection = session.getConnection();
        System.out.println(connection);
    }


}
