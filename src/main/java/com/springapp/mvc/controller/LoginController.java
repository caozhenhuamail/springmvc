package com.springapp.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by richard on 15-12-4.
 */

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password) throws  Exception {

        session.setAttribute("username", username);

        return "redirect:/items/queryItems";

    }

    @RequestMapping("logout")
    public String logout(HttpSession session) throws Exception {

        session.invalidate();

        return "redirect:/items/queryItems";
    }
}
