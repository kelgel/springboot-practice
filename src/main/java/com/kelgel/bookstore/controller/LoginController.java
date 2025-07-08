package com.kelgel.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URLEncoder;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String id, String password, Model model) throws Exception{
        if(loginCheck(id, password)){
            model.addAttribute("id", id);
            model.addAttribute("password", password);
            return "userInfo";
        }
        else{
            String msg = URLEncoder.encode("id 또는 pwd가 일치하지않습니다.", "utf-8");
            return "redirect:/login/login?msg="+msg; //URL Rewriting
        }
    }

    private boolean loginCheck(String id, String password) {
        return "aa".equals(id) && "11".equals(password);
    }
}
