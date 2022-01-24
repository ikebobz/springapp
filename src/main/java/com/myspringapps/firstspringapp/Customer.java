package com.myspringapps.firstspringapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Component
@Entity
public class Customer {
    public Customer()
    {

    }
    public Customer(Customer customer)
    {

    }
    @Id
    @GeneratedValue
    public Long id;
    public String firstname;
    public String lastname;
    public String middlename;
    public String address;
    public String mobile;
    public String email;

    @Override
    public String toString()
    {
       return String.format("The customer is %s %s %s",firstname,middlename,lastname); 
    }
    
}
