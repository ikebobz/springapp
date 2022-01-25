package com.myspringapps.firstspringapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Employee {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 public Long Id;
 
 public String firstname;
 public String lastname;
 public String address;
 public String mobile;
 public String email;
 public String Sex;

 public String toString()
 {
     return String.format("His/her names are %s %s who lives at %s and can be reached on %s",firstname,lastname,address,mobile);
 }
    
}
