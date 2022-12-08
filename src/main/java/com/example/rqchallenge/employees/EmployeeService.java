package com.example.rqchallenge.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    public Employee insert(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> searchEmployees(String searchString) {
        return employeeRepository.search("%" + searchString + "%");
    }

    public Employee findById(Long id) throws Exception {
        return employeeRepository.findById(id).get();
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Integer getHighestSalary() {
        return employeeRepository.getHighestSalary();
    }

    public List<String> getTopTenNamesBySalary() {
        return employeeRepository.getTopTenNamesBySalary();
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

}
