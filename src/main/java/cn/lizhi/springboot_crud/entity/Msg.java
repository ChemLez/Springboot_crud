package cn.lizhi.springboot_crud.entity;

import java.util.HashMap;
import java.util.Map;

public class Msg {

    // 200成功；500失败
    private Integer code;
    // 存储信息
    private String msg;

    // 存储对象信息
    private Map<String, Object> extend = new HashMap<String, Object>();

    public static Msg success() {
        Msg msg = new Msg();
        msg.setCode(200);
        return msg;
    }

    public static Msg fail() {
        Msg msg = new Msg();
        msg.setCode(500);
        return msg;
    }

    public Msg add(String key, Object object) {
        this.getExtend().put(key, object); //
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
