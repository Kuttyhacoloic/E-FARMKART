package com.efarmkart.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efarmkart.app.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
//find
//save , delete , findById , findAll , deleteById