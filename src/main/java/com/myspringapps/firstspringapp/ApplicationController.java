package com.myspringapps.firstspringapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    public ApplicationController()
    {

    }

    @Autowired
    private ProductOrderRepository por;

    @GetMapping("/circleArea")
    public double getArea(@RequestParam(name = "radi") double radius)
    {
        return 3.14 * radius * radius;

    }

    @GetMapping("/ordersbydesc")
    public List<ProductOrder> itemsByDescription(@RequestParam(name = "item")String item)
    {
        List<ProductOrder> orders = null;
        orders = por.findOrdersByDescriptionContains(item);
        return orders;
    }
}
