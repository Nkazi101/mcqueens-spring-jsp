package com.cardealer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cardealer.models.Car;
import com.cardealer.models.Cart;
import com.cardealer.services.CartService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.web.servlet.view.RedirectView;

import com.stripe.exception.StripeException;


@Controller
//allows you to have root/base route for all requests in a controller
@RequestMapping("/cart")
public class CartController {


    @Autowired
    private CartService cartService;



    //we use Model model because we're trying send over the cart session data to the cart webpage/jsp
   
  @GetMapping
    public String viewCart(Model model, HttpSession session){

        //this line is using the getCart method in the cart service to either get whatever cart is currently set in the user session or set a new cart in the user session.
        Cart cart = cartService.getCart(session);
         //this method is also passing over cart items to the cart page
        model.addAttribute("cartItems", cart.getItemsinCart());

        return "cart";

    }

    @GetMapping("/add/{id}")
    public String addtoCart(@PathVariable Long id, HttpSession session){

        cartService.addToCart(id, session);
        return "redirect:/cart";
    }

    @GetMapping("/remove/{id}")
    public String removeFromCart(@PathVariable Long id, HttpSession session){

        cartService.removeFromCart(id, session);

        return "redirect:/cart";
    }

  




}
