package com.study.blog.controller.admin;

import com.study.blog.po.User;
import com.study.blog.service.UserService;
import com.study.blog.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping
    public String loginPage() {
        return "admin/login";
    }

    @RequestMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes, Model model) {

        //获取当前用户
        Subject subject= SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);

        try{
            subject.login(token);
            return "admin/index";
        }catch (UnknownAccountException e){
            attributes.addFlashAttribute("message","用户名错误");
            System.out.println("用户名错误");
            return "redirect:/admin";
        }catch (IncorrectCredentialsException e){
            attributes.addFlashAttribute("message","密码错误");
            System.out.println("密码错误");
            return "redirect:/admin";
        }
//        User user = userService.checkUser(username, password);
//        if (user != null) {
//            user.setPassword(null);
//            session.setAttribute("user", user);
//            return "admin/index";
//        } else {
//            attributes.addFlashAttribute("message", "用户名和密码错误");
//            //为什么不用model，因为重定向的话model就会失效
//            return "redirect:/admin";
//        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/admin";
    }
}
