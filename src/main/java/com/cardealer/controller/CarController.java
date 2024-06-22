package com.cardealer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cardealer.models.Car;
import com.cardealer.services.CarService;


@Controller
public class CarController {


    //dependency injection allows us to use resources from another class or layer
    //e.g. we created the "findAvailableCars" method in CarService.java, and in order to use that method in the controller we do a dependency injection
    @Autowired
    private CarService carService;


    //the Model class allows you to send data to your webpages/jsp's
    //when do you use Model model as an input? When you want to send data to a webpage
    @GetMapping("/cars")
    public String displayCars(Model model){

        List<Car> cars = carService.findAvailableCars();



        //sends all the cars received from the "findavailableCars()" method over to the "availablecars.jsp" webpage
        model.addAttribute("cars", cars);

        return "availablecars";
        
    }

    //pathvariable allows you to extract data from the url path
    @GetMapping("/cardetail/{id}")
    public String carDetails(@PathVariable Long id, Model model) throws Exception {

        Car carDetail = carService.getCar(id);

        model.addAttribute("carDetail", carDetail);

        return "cardetails";

    }

    //requestparam allows spring to take input data from a search query or form data
    @GetMapping("/searchcar")
    public String searchCar(@RequestParam("model") String carModel, Model model){

        List<Car> cars = carService.findCarsByModel(carModel);

        model.addAttribute("cars", cars);

        return "availablecars";

    }


    @GetMapping("/addcar")
    public String addCar(){

        return "addcar";

    }


    @PostMapping("/addcar")
    public String addCarPost(@ModelAttribute Car car){

        carService.addCar(car);

        return "redirect:/cars";

    }


    

    
}
