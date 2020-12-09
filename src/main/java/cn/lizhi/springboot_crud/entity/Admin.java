package cn.lizhi.springboot_crud.entity;

import javax.persistence.*;

@Table(name = "tbl_admin")
public class Admin {
    @Id
    @Column(name = "admin_user_id")
    @GeneratedValue(generator = "JDBC")
    private Integer adminUserId;

    @Column(name = "login_user_name")
    private String loginUserName;

    @Column(name = "login_user_password")
    private String loginUserPassword;

    @Column(name = "nick_name")
    private String nickName;


    public Admin() {
    }

    public Admin(String loginUserName, String loginUserPassword) {
        this.loginUserName = loginUserName;
        this.loginUserPassword = loginUserPassword;
    }

    /**
     * @return admin_user_id
     */
    public Integer getAdminUserId() {
        return adminUserId;
    }

    /**
     * @param adminUserId
     */
    public void setAdminUserId(Integer adminUserId) {
        this.adminUserId = adminUserId;
    }

    /**
     * @return login_user_name
     */
    public String getLoginUserName() {
        return loginUserName;
    }

    /**
     * @param loginUserName
     */
    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
    }

    /**
     * @return login_user_password
     */
    public String getLoginUserPassword() {
        return loginUserPassword;
    }

    /**
     * @param loginUserPassword
     */
    public void setLoginUserPassword(String loginUserPassword) {
        this.loginUserPassword = loginUserPassword;
    }

    /**
     * @return nick_name
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminUserId=" + adminUserId +
                ", loginUserName='" + loginUserName + '\'' +
                ", loginUserPassword='" + loginUserPassword + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}