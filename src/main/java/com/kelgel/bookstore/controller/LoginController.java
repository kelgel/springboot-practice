package com.kelgel.bookstore.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URLEncoder;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest req, String id, String password, RedirectAttributes model) throws Exception{
        if(loginCheck(id, password)){
            model.addAttribute("id", id);
            model.addAttribute("password", password);
            return "userInfo";
        }
        else{
//            String msg = URLEncoder.encode("id 또는 pwd가 일치하지않습니다.", "utf-8");
            String msg = "id 또는 pwd가 일치하지않습니다.";
//            model.addAttribute("msg", msg); //appilcation.properties 파일에서 인코딩 설정
            model.addFlashAttribute("msg", msg);
            return "redirect:/login/login";
//            return "redirect:/login/login?msg="+msg; //URL Rewriting
        }
    }

    private boolean loginCheck(String id, String password) {
        return "aa".equals(id) && "11".equals(password);
    }
}
