package com.myspringapps.firstspringapp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:application.properties")
public class Calculator {

    public Calculator()
    {}

    public String brand;
    public String type;
    public Date yearManufacture;

    //Methods
    public double add(double val1,double val2)
    {
        return val1 + val2;
    }
    public double difference(double val1,double val2)
    {
        return val1 - val2;
    }
    public double product(double val1,double val2)
    {
        return val1 * val2;
    }
    public double quotient(double val1,double val2)
    {
        return val1 / val2;
    }
    public double sin(double value)
    {
        return Math.sin(value);
    }
    public double cos(double value)
    {
        return Math.cos(value);
    }
    public void setYearManufactured(Date date)
    {
        this.yearManufacture = date;
    }

    @Autowired
    public void setBrand(@Value("${brand}")String name)
    {
        this.brand = name;
    }
    @Autowired
    public void setTpe(@Value("${type}")String type)
    {
        this.type = type;
    }
    
}
