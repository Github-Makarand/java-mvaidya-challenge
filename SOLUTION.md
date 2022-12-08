# Name
## java-challenge
#
## Description
This project is written to solve the java-employee-challenge posed by ReliaQuest as a part of their selection process.

## Solutin steps

1. Create a personal gitlab repository

https://gitlab.com/rqchallenge/java-challenge.git

Clone challenge code from provided challenge repository.
Remove the remote origin pointing to challenge repo.
Add remote origin pointing to solution repository.
commit and push the baseline code to solution repo, before making any code changes.

2. Reviewed the given README file. 

Found some descrepencies in the input. 
Revised the README file to remove these decrepencies.

Specs for a couple of end points were missing from the README.
Added the specs for completion.

3. Created tests for TDD

I was familiar with TDD concepts, but have never used the Springboot API tests.
Browsed the web to learn TDD for springboot.

Tried a few testcase for verification.
These trail cases are **not** checked in to the repo.

Created test cases for various usage scenarios in RQChallengeApplicationTests.java
Created test data to be inserted in database before every test.

4. Included JPA, Hibernate and H2 database in build.gradle, using H2 databse for data storage.

5. Updated IEmployeeController interface

Since the expected output was different from what the interface was returning add a RQResponse class template.
Updated the mapping URLs to match as per the modified README file.
Created implementation of IEmployeeController interface in a new class EmployeeController.

6. Added Entity Employee and related functions

Implemented all functions required to pass the tests.
Performed all tests to ensure all test are passing.

Checked in the code to repo.

## License
This code is written as a solution to the java-employee-challenge.
It is not expected to be reused or distributed.

## Contribution

Makarand Vaidya - vaidya.mak@gmail.com is a sole contributer to this project.

Following links  have been used as a reference to solve this challenge

https://docs.gitlab.com/ee/
https://docs.spring.io/spring-framework/docs/current/reference/html/
https://spring.io/guides/gs/testing-web/
https://hibernate.org/orm/documentation/6.1/

Several other tutorials available on the net.

## Project status
Completed expected functionality.

Some of the improvements possible (NOT implemented)

- Move all strings to constants and / or resource files.
- Add more failure test cases.
- Verify results from database, after test execution.

