package com.myspringapps.firstspringapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Product {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public Long id;
public String description;
public double price;

@Override
public String toString()
{
    return String.format("Description:%s\nPrice:%.2f", description,price);
}
    
}
