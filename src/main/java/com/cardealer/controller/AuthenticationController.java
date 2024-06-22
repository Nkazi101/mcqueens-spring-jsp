package com.cardealer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cardealer.services.AuthenticationService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthenticationController {
    

    @Autowired
    private AuthenticationService authService;



    //@RequestParam allows spring to extract input data that could be passed from form data, or a query parameter
    @PostMapping("/signin")
    public String signIn(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, Model model){

        try {

            Object user = authService.signIn(email, password);
            System.out.println(user);
            //set the user in the session

            model.addAttribute("user", user);

            session.setAttribute("user", user);
            //set the user type(buyer/seller) in the session
            session.setAttribute("userType", user.getClass().getSimpleName());
            
            return "home";
        }
        
       catch(Exception e){

            return "sign-in";
       }

    }
}
