package com.example.rqchallenge.employees;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public interface IEmployeeController {

    @GetMapping("/employees")
    ResponseEntity<RQResponse<List<Employee>>> getAllEmployees() throws IOException;

    @GetMapping("/employee/searchByName/{searchString}")
    ResponseEntity<RQResponse<List<Employee>>> getEmployeesByNameSearch(@PathVariable String searchString);

    @GetMapping("/employee/{id}")
    ResponseEntity<RQResponse<Employee>> getEmployeeById(@PathVariable Long id);

    @GetMapping("/employee/highestSalary")
    ResponseEntity<RQResponse<Integer>> getHighestSalaryOfEmployees();

    @GetMapping("/employee/topNamesBySalary")
    ResponseEntity<RQResponse<List<String>>> getTopTenHighestEarningEmployeeNames();

    @PostMapping("/employee")
    ResponseEntity<RQResponse<Employee>> createEmployee(@RequestBody Map<String, Object> employeeInput);

    @DeleteMapping("/employee/{id}")
    ResponseEntity<RQResponse<String>> deleteEmployeeById(@PathVariable Long id);

}
