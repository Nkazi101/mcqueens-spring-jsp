package com.cardealer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardealer.models.Buyer;
import com.cardealer.repository.BuyerRepository;

import jakarta.servlet.http.HttpSession;


//The Warehouse(Services)
//methods in this layer which will allow you to manipulate data before it reaches the database or if it is coming from the database and going to a view/webpage
//business logic layer
@Service
public class BuyerService {

    //dependency injection
    @Autowired
    private BuyerRepository buyerRepository;


    //this method takes in a buyer object and asks the buyerRepository to insert it(or save) into the database
    //access modifier, return type, method name (parameters) { body of code}
        public Buyer signUp(Buyer buyer){


            //other code depending on what you want to do with the data before it reaches the database, e.g. encrypting the password

            //data_type variable = ask middleman to save buyer 
            Buyer savedBuyer = buyerRepository.save(buyer);
            
            return savedBuyer;

        }

        //this method takes in a buyer object and checks if they exist and if the password matches
        public Buyer signIn(Buyer buyer) throws Exception {

            //check whether the buyer exists in the database, using their email
            Buyer foundBuyer = buyerRepository.findByEmail(buyer.getEmail());
            
            //checking if the buyerrepository found anything in the database with the entered email
            if(foundBuyer == null){
                throw new Exception("Buyer not found");
            }

            //check if the password for the foundbuyer from the database matches the password from the buyer entered in the view/jsp page
            if(!foundBuyer.getPassword().equals(buyer.getPassword())){
                throw new Exception("Invalid credenitials. Wrong password");
            }

            return foundBuyer;


        }


        public Buyer findById(Long id){

            Buyer buyer = buyerRepository.findById(id).orElse(null);

            return buyer;


        }


        public Buyer editProfile(Buyer buyer, HttpSession session){

            Buyer sessionBuyer  = (Buyer) session.getAttribute("loggedinbuyer");


            //go to the database and find the buyer that i want to edit based on the id i give you
            Buyer editedbuyer = buyerRepository.findById(sessionBuyer.getId()).orElse(null);

            editedbuyer.setFirstName(buyer.getFirstName());
            editedbuyer.setLastName(buyer.getLastName());
            editedbuyer.setAddress(buyer.getAddress());
            editedbuyer.setEmail(buyer.getEmail());
            editedbuyer.setPhoneNumber(buyer.getPhoneNumber());

            return buyerRepository.save(editedbuyer);

        }


    
}
