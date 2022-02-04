package com.myspringapps.firstspringapp;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public interface ProductOrderRepository extends PagingAndSortingRepository<ProductOrder,Long>{
    public List<ProductOrder> findOrdersByDescriptionContains(@Param("desc")String desc);
    public List<ProductOrder> findOrderByOrderDate(@Param("date")String date);

    @Query("from ProductOrder where orderDate between ?1 and ?2")
    public List<ProductOrder> findOrderByDateBetween(@Param("low") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date lower,@Param("high") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date upper);

}