package com.cardealer.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    //many to many
    //multiple instances of one class are related to multiple instance of another class
    //a car can be in multiple carts, and a cart can have multiple cars
    //a many to many joins two tables into one by taking the primary key's from each table and using them to form a new table.

    @ManyToMany
    //jointable links to entities/models together
    @JoinTable(
        name = "car_cart",
        joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"))
    private List<Car> itemsinCart = new ArrayList<>();


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public List<Car> getItemsinCart() {
        return itemsinCart;
    }


    public void setItemsinCart(List<Car> itemsinCart) {
        this.itemsinCart = itemsinCart;
    }






    
}
