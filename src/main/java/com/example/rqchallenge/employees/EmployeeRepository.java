package com.example.rqchallenge.employees;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAll();

    @Query("SELECT e FROM Employee e WHERE e.name LIKE ?1")
    List<Employee> search(String searchString);

    @Query("SELECT MAX(e.salary) FROM Employee e")
    Integer getHighestSalary();

    @Query(nativeQuery = true, value = "SELECT e.name FROM Employee e ORDER BY e.salary DESC LIMIT 10")
    List<String> getTopTenNamesBySalary();
    
}
