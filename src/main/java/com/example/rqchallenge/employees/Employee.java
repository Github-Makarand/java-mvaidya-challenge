package com.example.rqchallenge.employees;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    private Long salary;

    public Employee() {
    }

    public Employee(String _name, Integer _age, Long _salary) {
        this.id = null;
        this.name = _name;
        this.age = _age;
        this.salary = _salary;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Long getSalary() {
        return salary;
    }

}
