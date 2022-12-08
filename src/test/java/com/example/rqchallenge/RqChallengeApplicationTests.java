package com.example.rqchallenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import com.example.rqchallenge.employees.Employee;
import com.example.rqchallenge.employees.EmployeeService;

@SpringBootTest(classes = RqChallengeApplication.class)
@AutoConfigureMockMvc
class RqChallengeApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private EmployeeService employeeService;

    /**
     * Create employee records for tests
     */
    @BeforeEach
    public void init() {
        try {
            employeeService.deleteAll();
            employeeService.insert(new Employee("Asking Questions", 20, 36000L));
            employeeService.insert(new Employee("Better Results", 20, 36000L));
            employeeService.insert(new Employee("Complex Product", 22, 40000L));
            employeeService.insert(new Employee("Deep Learning", 32, 42000L));
            employeeService.insert(new Employee("Exceed Expectations", 40, 80000L));
            employeeService.insert(new Employee("Fair Expectations", 49, 87000L));
            employeeService.insert(new Employee("Great Achievements", 30, 60000L));
            employeeService.insert(new Employee("Highest Order", 35, 70000L));
            employeeService.insert(new Employee("Invaluable Support", 50, 100000L));
            employeeService.insert(new Employee("Jail Breaker", 51, 110000L));
            employeeService.insert(new Employee("Kind Attention", 52, 120000L));
            employeeService.insert(new Employee("Lime Light", 58, 1000000L));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test to get all employees
     */

    @Test
    public void testGetAllEmployees() {
        try {
            mvc.perform(MockMvcRequestBuilders
                    .get("/api/v1/employees")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("success"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.data").isArray())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.data.length()").value(12));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test to search employees by name
     */

    @Test
    public void testSearchEmployees() {
        try {
            mvc.perform(MockMvcRequestBuilders
                    .get("/api/v1/employee/searchByName/Expect")
                    .accept(MediaType.APPLICATION_JSON))
                    
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("success"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.data").isArray())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.data.length()").value(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            mvc.perform(MockMvcRequestBuilders
                    .get("/api/v1/employee/searchByName/Unexpected")
                    .accept(MediaType.APPLICATION_JSON))
                    
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("success"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.data").isArray())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.data.length()").value(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test to fetch a single employee using its id
     */
    @Test
    public void testGetEmployeeById() {
        try {
            List<Employee> allEmployees = employeeService.getAllEmployees();
            if (allEmployees.size() > 0) {
                mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/employee/" + allEmployees.get(0).getId())
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("success"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.data").exists())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.data.name").value(allEmployees.get(0).getName()));
            } else {
                throw new Exception("Employee not found in test data");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            mvc.perform(MockMvcRequestBuilders
                    .get("/api/v1/employee/100")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("error"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Test to fetch Highest Salary
     */
    @Test
    public void testGetHighestSalary() {
        try {
            mvc.perform(MockMvcRequestBuilders
                    .get("/api/v1/employee/highestSalary")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("success"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.data").exists())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.data").value(1000000L));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test to fetch names of top ten employees
     */
    @Test
    public void testGetTopTenEmployees() {
        try {
            mvc.perform(MockMvcRequestBuilders
                    .get("/api/v1/employee/topNamesBySalary")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("success"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.data").exists())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.data").isArray())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.data.length()").value(10));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test to create an employee
     */
    @Test
    public void testCreateEmployee() {
        String employeeInput = "{ \"name\" : \"More Input\", \"age\" : \"45\", \"salary\" : \"100000\" }";
        try {
            mvc.perform(MockMvcRequestBuilders
                    .post("/api/v1/employee")
                    .content(employeeInput)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("success"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.data").exists())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.data.name").value("More Input"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test to delete an employee
     */
    @Test
    public void testDeleteEmployee() {
        try {

            List<Employee> allEmployees = employeeService.getAllEmployees();
            int size = allEmployees.size();
            if (size > 0) {
                mvc.perform(MockMvcRequestBuilders
                        .delete("/api/v1/employee/" + allEmployees.get(size - 1).getId())
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("success"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("successfully! deleted Record"));
            } else {
                throw new Exception("Employee not found in test data to delete");
            }
            int newSize = employeeService.getAllEmployees().size();
            if (size == newSize) {
                throw new Exception("Employee not deleted in database");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
