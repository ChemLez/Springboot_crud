package cn.lizhi.springboot_crud.controller;

import cn.lizhi.springboot_crud.entity.Admin;
import cn.lizhi.springboot_crud.mapper.AdminMapper;
import cn.lizhi.springboot_crud.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;


    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {

        Admin login = adminService.login(username, password);
        if (login == null) {
            // 用户名或者密码错误,跳转首页
            model.addAttribute("msg", "用户名或者密码错误");
            return "index";
        } else {
            // 将用户信息保存到session中
            session.setAttribute("user",login);
            return "redirect:list.html";
        }
    }

}
