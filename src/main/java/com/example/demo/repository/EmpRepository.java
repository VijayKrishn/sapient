package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface EmpRepository extends CrudRepository<Employee, Serializable> {

	public List<Employee> findBySalary(Double sal);

	public List<Employee> findByName(String name);

	public List<Employee> findByNameAndSalary(String name, Double sal);

	public List<Employee> findBySalaryGreaterThan(Double sal);
	
	

	@Query("select salary from Employee where name=:name")
	public Double findEmpSalByName(@Param("name") String name);

}