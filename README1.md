# UserMgmtRestService

User Management Rest Service using Spring boot,Spring MVC,HSQLDB and Hibernate.

## Getting Started

Source Code

It has following modules:
1 Controller
   1.1 ControllerValidationHandler
	Use to handle all exception
   2.2 UserController
       Has all services mapping
2 Domain
	2.1 User
		Entity Details

3 Dto
        3.1 MessageDTO- To save error status and message
4 Exception
        4.1 Custome Exception
5 Repository
      UserRepository Contains the query

6 Service
    UserService
    Interface listed with all service
    UserServiceImpl
    UserService interface impl

7 UsermanagementApplication
    Config Class
7 Config File


Junit Test Cases

1 Controller
It has three test cases for three CRUD operation using Junit and Mockito
