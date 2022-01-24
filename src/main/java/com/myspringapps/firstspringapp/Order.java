package com.myspringapps.firstspringapp;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;
    Date orderDate;
    Long[] items;
}
