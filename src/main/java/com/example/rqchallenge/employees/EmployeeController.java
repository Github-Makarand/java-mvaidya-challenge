package com.example.rqchallenge.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class EmployeeController implements IEmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<RQResponse<List<Employee>>> getAllEmployees() throws IOException {
        List<Employee> employeeList = employeeService.getAllEmployees();
        return new ResponseEntity<RQResponse<List<Employee>>>(new RQResponse<List<Employee>>(employeeList), HttpStatus.OK);
    }

    @GetMapping("/employee/searchByName/{searchString}")
    public ResponseEntity<RQResponse<List<Employee>>> getEmployeesByNameSearch(@PathVariable String searchString){
        List<Employee> employeeList = employeeService.searchEmployees(searchString);
        return new ResponseEntity<RQResponse<List<Employee>>>(new RQResponse<List<Employee>>(employeeList), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<RQResponse<Employee>> getEmployeeById(@PathVariable Long id) {
        Employee employee;
        try {
            employee = employeeService.findById(id);
            return new ResponseEntity<RQResponse<Employee>>(new RQResponse<Employee>(employee), HttpStatus.OK);
        } catch (Exception e) {
        }
        return new ResponseEntity<RQResponse<Employee>>(new RQResponse<Employee>("error", null, "Employee not found"), HttpStatus.OK);
    }

    @GetMapping("/employee/highestSalary")
    public ResponseEntity<RQResponse<Integer>> getHighestSalaryOfEmployees() {
        Integer highestSalary = employeeService.getHighestSalary();
        return new ResponseEntity<RQResponse<Integer>>(new RQResponse<Integer>(highestSalary), HttpStatus.OK);
    }

    @GetMapping("/employee/topNamesBySalary")
        public ResponseEntity<RQResponse<List<String>>> getTopTenHighestEarningEmployeeNames() {
        List<String> names = employeeService.getTopTenNamesBySalary();
        return new ResponseEntity<RQResponse<List<String>>>(new RQResponse<List<String>>(names), HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<RQResponse<Employee>> createEmployee(@RequestBody Map<String, Object> employeeInput) {

        String name = (String)employeeInput.get("name");
        Integer age = Integer.parseInt((String)employeeInput.get("age"));
        Long salary = Long.parseLong((String) employeeInput.get("salary"));

        Employee employee = new Employee(name, age, salary);
        employee = employeeService.save(employee);
        return new ResponseEntity<RQResponse<Employee>>(new RQResponse<Employee>(employee), HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<RQResponse<String>> deleteEmployeeById(@PathVariable Long id) {
        employeeService.delete(id);
        return new ResponseEntity<RQResponse<String>>(new RQResponse<String>("success", null, "successfully! deleted Record"), HttpStatus.OK);
    }

}
