# Full Stack Test Automation Project
[Desktop Test Automation - Demo](https://drive.google.com/file/d/14KxQOjtzgniBOTD53Q9iJqreHTfcp1gc/view?usp=sharing)

### This project created to demonstrate my knowledge and skills in Automation Testing
***
### About
The project demonstrates a smart automation infrastructure. It is built in hierarchy order of modules. The modules contain number of classes with methods. There are main/common/helpers/actions/page_object modules. In this way, the tests can be created in very simple way with a minimum lines of code. Also the infrastructure allows to work with different kinds of applications. **Big advantage of the infrastructure is that it can be easy maintained!**

### Project Overview
The project is an example of infrastructure for automation testing of different kinds of applications:

* Web based application
* Mobile application
* Web API
* Electron application
* Desktop application

### Infrastructure project includes using of:

* Page Object Design Pattern
* Project Layers(Extensions/Work Flows/Test Cases...)
* Support of Different Clients/Browsers
* Failure Mechanism
* Common Functionality
* External Files Support
* Reporting System (including screenshots)
* Visual Testing
* DB support
* CI support
***
### List of applications were used in this project:

* Conduit webpage - Web based application
* [TeamApp](https://github.com/EsterYIT/TeamApp) - Mobile application
* GitHub API
* Electron application
* Windows notepad - Desktop application

### Tools & Frameworks used in the project:
* TestNG - Testing Framework
* Listeners - interface used to generate logs and customize the TestNG reports
* MySQL - used for login to Conduit web page
* Jenkins- for tests execution
* REST Assured - for API testing
* Allure Reports - as the main reporting system
* Sikuli - for visual testing

### Tests Execution:
Each of the applications has a few tests for demonstration purpose. These tests can be developed in a very simple way, due to a lot of work with the infrastructure. [[Sanity Tests]](https://github.com/EsterYIT/TestAutomationProject/tree/master/src/test/java/sanity)

### Known Issues:
Sometimes can be conflicts with some dependencies the applications are using. Hence, the project is for DEMO purpose only. In production it should be divided into several projects.

### Jenkins Dashboard:

![jenkins dashboard](https://user-images.githubusercontent.com/106423697/228176437-c9c6a59d-c0aa-48bb-b32b-cb1b6d674ee8.png)

### System Requirements
* [Beak](https://beakit.com/)
<img src="https://t.bkit.co/w_647df09e2478f.gif" />




