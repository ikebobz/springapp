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

    @Autowired
    private ProductRepository pr;
    
    @Autowired
    private Calculator calculator;

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

    @GetMapping("getproducts/{keyword}")
    public ResponseEntity<List<Product>> getProducts(@PathVariable String keyword)
    {
        return new ResponseEntity<>(pr.findByDescriptionContains(keyword),HttpStatus.OK);
    }
    @GetMapping("funcadd")
    public double getSum(@RequestParam(name = "val1")double val1,@RequestParam(name = "val2")double val2)
    {
        return calculator.add(val1, val2);
    }

    @GetMapping("funcsub")
    public double getDifference(@RequestParam(name = "val1")double val1,@RequestParam(name = "val2")double val2)
    {
        return calculator.difference(val1, val2);
    }

    @GetMapping("funcprod")
    public double getProduct(@RequestParam(name = "val1")double val1,@RequestParam(name = "val2")double val2)
    {
        return calculator.product(val1, val2);
    }

    @GetMapping("funcdiv")
    public double getQuotient(@RequestParam(name = "val1")double val1,@RequestParam(name = "val2")double val2)
    {
        return calculator.quotient(val1, val2);
    }

    @GetMapping("funcsin")
    public double getSine(@RequestParam(name = "val")double value)
    {
        return calculator.sin(value);
    }

    @GetMapping("funccos")
    public double getCos(@RequestParam(name = "val")double value)
    {
        return calculator.cos(value);
    }

    @GetMapping("calculator")
    public String getType()
    {
        return String.format("Calculator details are type: %s\nBrand: %s", calculator.type,calculator.brand);
    }

    
}
