package com.cardealer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cardealer.models.Car;
import com.cardealer.models.Cart;
import com.cardealer.services.CartService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

import jakarta.servlet.http.HttpSession;

@Controller
public class StripeController {

    @Autowired
    private CartService cartService;

//the apikey is needed inside a method so that the method can access/use the api service
@Value("${stripe.apiKey}")
public String stripeApiKey;


@GetMapping("/create-session")
public String createCheckout(HttpSession session){


Stripe.apiKey = stripeApiKey;


Cart cart = cartService.getCart(session);


//we want several line items because a cart can hold several cars

List<SessionCreateParams.LineItem> lineitems = new ArrayList<>();

for(Car car: cart.getItemsinCart()){

lineitems.add(
    //this will allow me to build/create each line item for each car
    SessionCreateParams.LineItem.builder()
    .setPrice(car.getStripePriceId())
    .setQuantity(1L)
    .build()

);

}

SessionCreateParams params =
  SessionCreateParams.builder()
    .setSuccessUrl("http://localhost:8080/checkout/success")
    .addAllLineItem(lineitems)
    .setMode(SessionCreateParams.Mode.PAYMENT)
    .build();

    try{

        //creating the checkout session
    Session session1 = Session.create(params);
    //load the session as a url
    return "redirect:" + session1.getUrl();

    }
    catch(StripeException e){

        return "redirect:/checkout/error";

    }


}


@GetMapping("/checkout/success")
public String success(){


    return "success";
}




}

    
    
