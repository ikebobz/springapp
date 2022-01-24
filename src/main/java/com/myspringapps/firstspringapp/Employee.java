package com.myspringapps.firstspringapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Employee {
 public Employee(String[] values){
     this.firstname = values[1];
     this.lastname = values[2];
     this.address = values[3];
     this.mobile = values[4];
     this.email = values[5];
     this.Sex = values[6];

 }

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
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
