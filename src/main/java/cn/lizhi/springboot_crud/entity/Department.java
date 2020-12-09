package cn.lizhi.springboot_crud.entity;

import javax.persistence.*;

@Table(name = "tbl_dept")
public class Department {
    @Id
    @Column(name = "dept_id")
    @GeneratedValue(generator = "JDBC")
    private Integer deptId;

    @Column(name = "dept_name")
    private String deptName;

    public Department() {
    }

    public Department(Integer deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    /**
     * @return dept_id
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * @param deptId
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * @return dept_name
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}