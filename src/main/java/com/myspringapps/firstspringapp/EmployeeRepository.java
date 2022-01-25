package com.myspringapps.firstspringapp;

import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "employees",path = "employees")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
  @Query("from Employee where firstname = ?1")
  List<Employee> getbyFirstName(@Param("name")String firstname); 

  @Query("from Employee where lastname = ?1")
  List<Employee> getByLastName(@Param("lname")String surname);

  @Query("from Employee where frstname = ?1 and lastname = ?2")
  List<Employee> byBothNames(@Param("fname")String fname,@Param("lname")String lname);

  @Query("from Employee where email = ?1")
  List<Employee> byEmail(@Param("email")String email);

  @Query("from Employee where address like %?1%")
  List<Employee> findByAddressContains(@Param("address")String address);
}
