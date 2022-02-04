package com.myspringapps.firstspringapp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    public ApplicationController()
    {

    }

    @Autowired
    private ProductOrderRepository por;

    @Autowired
    private EmployeeRepository er;

    @GetMapping("/circleArea")
    public double getArea(@RequestParam(name = "radi") double radius)
    {
        return 3.14 * radius * radius;

    }

    @GetMapping("ordersbydesc")
    public ResponseEntity<List<ProductOrder>> itemsByDescription(@RequestParam(name = "item")String item)
    {
      return new ResponseEntity<>(por.findOrdersByDescriptionContains(item),HttpStatus.OK); 
    }
    @GetMapping("ordersbydesc/{phrase}")
    public ResponseEntity<List<ProductOrder>> getOrdersByDescription(@PathVariable String phrase)
    {
      return new ResponseEntity<>(por.findOrdersByDescriptionContains(phrase),HttpStatus.OK);  
    }
    
    @GetMapping("staff")
    public ResponseEntity<List<Employee>> getEmployeesByNames(@RequestParam(name = "fname") String firstname, @RequestParam(name = "lname") String lastname)
    {
        return new ResponseEntity<>(er.byBothNames(firstname, lastname),HttpStatus.OK);
    }
    
    
    @GetMapping("staff/1/{firstname}")
    public ResponseEntity<List<Employee>> getEmployeesbyFirstName(@PathVariable String firstname)
    {
        return new ResponseEntity<>(er.getbyFirstName(firstname),HttpStatus.OK);
    }

    @GetMapping("staff/2/{lastname}")
    public ResponseEntity<List<Employee>> getEmployeesBySurname(@PathVariable String lastname)
    {
        return new ResponseEntity<>(er.getByLastName(lastname),HttpStatus.OK);
    }

    @GetMapping("orderbydate")
    public ResponseEntity<List<ProductOrder>> getOrdersByDate(@RequestParam(name="lower") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date lower,@RequestParam(name="upper") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date upper)
    {
        return new ResponseEntity<>(por.findOrderByDateBetween(lower, upper),HttpStatus.OK);
    }

    
}
