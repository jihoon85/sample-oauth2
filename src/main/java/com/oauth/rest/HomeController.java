package com.oauth.rest;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String getUserName(Model model, OAuth2AuthenticationToken token) {
        
        Map<String, Object> userinfo = token.getPrincipal().getAttributes();

        System.out.println(userinfo.toString());
        
        model.addAttribute("userName", token.getPrincipal().getAttributes());
        
        return "index";
    }
    
    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        
        return "login";
    }
}
