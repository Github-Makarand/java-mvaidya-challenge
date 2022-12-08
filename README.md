# Coding Challenge

**This README file was having some inconsistencies. The file has been edited to remove those.**

### In this assessment you will be tasked with filling out the functionality of different methods that will be listed further down.
These methods will require some level of api interactions with the following base url: https://dummy.restapiexample.com.
Please keep the following in mind when doing this assessment: clean coding practices, test driven development, logging, and scalability.
If you are unable to successfully receive responses from the endpoints, mocking the response calls may prove to be helpful.

### Endpoints to implement

getAllEmployees()

    output - list of employees
    description - this should return all employees

getEmployeesByNameSearch()

    output - list of employees
    description - this should return all employees whose name contains or matches the string input provided

getEmployeeById(string id)

    output - employee
    description - this should return a single employee

getHighestSalaryOfEmployees()

    output - integer of the highest salary
    description -  this should return a single integer indicating the highest salary of all employees

getTop10HighestEarningEmployeeNames()

    output - list of employees
    description -  this should return a list of the top 10 employees based off of their salaries

createEmployee(string name, string salary, string age)

    output - string of the status (i.e. success)
    description -  this should return a status of success or failed based on if an employee was created

deleteEmployee(String id)

    output - the name of the employee that was deleted
    description - this should delete the employee with specified id given

### External endpoints from base url
#### This section will outline all available endpoints and their request and response models from https://dummy.restapiexample.com

/employees

    request:
        method: GET
        parameters: n/a
        full route: https://dummy.restapiexample.com/api/v1/employees
    response:
        {
            "status": "success",
            "data": [
                {
                "id": "1",
                "name": "Tiger Nixon",
                "salary": "320800",
                "age": "61",
                "id": "1"
                },
                ....
            ]
        }

/employee/searchByName/{searchString}

    request:
        method: GET
        parameters:
            searchString: (string)
        full route: https://dummy.restapiexample.com/api/v1/employee/searchByName/{searchString}
    response:
        {
            "status": "success",
            "data": [
                {
                "id": "1",
                "name": "Tiger Nixon",
                "salary": "320800",
                "age": "61",
                "id": "1"
                },
                ....
            ]
        }

/employee/{id}

    request:
        method: GET
        parameters: 
            id (String)
        full route: https://dummy.restapiexample.com/api/v1/employee/{id}
    response: 
        {
            "status": "success",
            "data": {
                "id": "1",
                "name": "Foo Bar",
                "salary": "320800",
                "age": "61",
                "id": "1"
            }
        }

/employee/highestSalary

    request:
        method: GET
        parameters:
            none 
        full route: https://dummy.restapiexample.com/api/v1/employee/highestSalary
    response:
        {
            "status": "success",
            "data": 100000
        }

/employee/topNamesBySalary

    request:
        method: GET
        parameters:
            none 
        full route: https://dummy.restapiexample.com/api/v1/employee/topNamesBySalary
    response:
        {
            "status": "success",
            "data": [
                "Tiger Nixon",
                "Foo Bar",
                ... (MAX 10)
            ]
        }

/employee/create

    request:
        method: POST
        parameters: 
            name (String),
            salary (String),
            age (String)
        full route: https://dummy.restapiexample.com/api/v1/employee/create
    response:
        {
            "status": "success",
            "data": {
                "name": "test",
                "salary": "123",
                "age": "23",
                "id": 25
            }
        }

/employee/delete/{id}

    request:
        method: DELETE
        parameters:
            id (String)
        full route: https://dummy.restapiexample.com/api/v1/employee/delete/{id}
    response:
        {
            "status": "success",
            "message": "successfully! deleted Record"
        }
