package com.example.trello.controllers;

import com.example.trello.configs.security.SessionUser;
import com.example.trello.configs.security.UserDetails;
import com.example.trello.dto.auth.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @RequestMapping(value = {"", "/home"}, method = RequestMethod.GET)
    public String homePage() {
        return "mainHome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/login?error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage() {
        return "logout";
    }

    @RequestMapping(value = "/chooseMainUrl/", method = RequestMethod.GET)
    public String chooseUrl(HttpSession session) {
        UserDetails details = SessionUser.session();
        session.setAttribute("user",details);
        if (details.isSuper()) return "redirect:/organization/list/";
        else if (details.isAdmin()) return "redirect:/project/list/";
        return "redirect:/task/list/";
    }

    @GetMapping("register")
    public String register(final Model model) {
        model.addAttribute("userData", new UserDto());
        return "register";
    }
}
