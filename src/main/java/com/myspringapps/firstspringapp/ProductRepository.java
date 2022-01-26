package com.myspringapps.firstspringapp;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "products",path = "products")
public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
    
    
    public List<Product> findByDescriptionContains(@Param("word")String word);
    
}
