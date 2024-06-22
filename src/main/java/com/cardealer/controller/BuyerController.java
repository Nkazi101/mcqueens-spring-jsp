package com.cardealer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.cardealer.models.Buyer;
import com.cardealer.services.BuyerService;

import jakarta.servlet.http.HttpSession;


//Customer Service Desk(controllers)
//the controller is the middleman between your views/jsp and your application
@Controller
public class BuyerController {

    //dependency injection
    @Autowired
    private BuyerService buyerService;

    //http methods/mappings
    //GET - retrieve or load a resource, e.g. just loading a webpage
    //POST - submitting data, e.g. signing up, creating a new resource
    //PUT - update a record or entity, e.g. updating car information, or updating user profile
    //DELETE - if you're trying to delete a particular resource

    

    @GetMapping("/signup")
    public String signUp(){

        return "sign-up";
    }

    //@Modelattribute is going to bind the data from the form to the input object, i.e. the data coming from the sign up form will be bound to "buyer".
    @PostMapping("/signup")
    public String submitsignUp(@ModelAttribute Buyer buyer){


        //this will send the buyer object from the sign up page to the buyer service
        buyerService.signUp(buyer);

        //load sign in webpage
        return "sign-in";

    }


    @GetMapping("/signin")
    public String signIn(){

        return "sign-in";
    }


    // //the Model class allows you to send data to your webpages/jsp's
    // //when do you use Model model as an input? When you want to send data to a webpage
    // @PostMapping("/signin")
    // public String submitSignin(@ModelAttribute Buyer buyer, Model model, HttpSession session){

    //     //we use try/catch in case the buyer's information is false or the buyer doesn't exist
    //     //it will TRY to sign the buyer in using the code in the try block, and if it fails, it will run the code in the CATCH block
    //     try{

    //         //this will send the buyer object(email/password) to the sign in method in the Buyer Service. the sign in method in the buyer service will return the signed in buyer and it will be stored in "loggedinBuyer"
    //         Buyer loggedinBuyer = buyerService.signIn(buyer);

    //         //this will save/set the loggedinBuyer in the user session.
    //         //when you set an object/value in the user session, you can get it whenever you want else where in the application
    //         session.setAttribute("loggedinbuyer",loggedinBuyer);

    //         //model has a method called addattribute which allows you to send an object/entity to a webpage
    //         model.addAttribute("buyer", loggedinBuyer);

    //         //load homepage if successfully signed in
    //         return "home";

    //     } 

    //     //if any exceptions(problems signing in) occur in the sign in method in the Buyer Service, the code in the catch statement will run, i.e. it will reload the sign-in page
    //     catch(Exception e){

    //         return "sign-in";
    //     }
       

    // }


    @GetMapping("/profile")
    public String profile(Model model, HttpSession session){

        //we use the session object to get the buyer that was set in the session at signin, and we store that buyer inside "buyer"(light blue).
        Buyer sessionbuyer = (Buyer) session.getAttribute("user");

        Buyer buyer = buyerService.findById(sessionbuyer.getId());
        //we check if buyer is empty, because if it is empty it means no one has signed in, so it will load the sign-in page so that someone can sign in
        if(buyer == null ){
            return "sign-in";
        }
        //if it is not empty, it means a buyer was set in the session at sign in, and we want to pass the logged in buyer object to the profile webpage so we can view their profile.
        else{

            model.addAttribute("buyer", buyer);

            return "profile";

        }

    }


    //persistence is the ability to save and retrieve the state of an object from the database


    @GetMapping("/editprofile/{id}")
    public String editProfile(@PathVariable Long id, Model model){

        Buyer buyerProfile = buyerService.findById(id);

        if(buyerProfile != null){

            model.addAttribute("buyerprofile", buyerProfile);

            return "editprofile";
        }
        else{
            return "redirect:/signup";
        }

    }

    @PostMapping("/editprofile")
    public String editProfileForm(@ModelAttribute Buyer buyer, HttpSession session){

        buyerService.editProfile(buyer, session);

        return "redirect:/profile";

    }





    @GetMapping("/logout")
    public String logout(HttpSession session){

        //this will remove/clear the logged in buyer from the session
        //invalidates this session then unbinds any objects bound to it.
        session.invalidate();

        return "redirect:/signin";
    }








}
