package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URLEncoder;

@Controller
@RequestMapping("/login")
public class LoginController {
    //@RequestMapping("/login")
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    //하나의 메서드로 GET, POST를 모두 처리해야 하는 경우
    //ReqeustMapping(value="/login/login", method= {RequestMethod.GET, RequestMethod.POST})

    //@RequestMapping(value="/login/login", method= RequestMethod.POST)
    @PostMapping("/login")
    public String login(String id, String pwd, Model model) throws Exception{
        //1. id, pwd 확인
        if(loginCheck(id, pwd)) {
            // 2. 일치하면 userInfo.html
            model.addAttribute("id", id);
            model.addAttribute("pwd", pwd);
            return "userInfo";
        }

        else { //  일치하지 않으면 login.html
            String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "UTF-8");
            return "redirect:/login/login?msg=" + msg;
        }

    }

    private boolean loginCheck(String id, String pwd) {
        return "aa".equals(id) && "11".equals(pwd);
        // return id.equals("aa") && pwd.equals("11"); //NullPointerException 검사 필요
    }
}
