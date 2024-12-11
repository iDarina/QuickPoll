### What is a spring bean?
A bean is an instance of a class managed by the Spring container. The container is responsible for creating, 
initializing, and managing the lifecycle of these beans

### What is Dependency injection?
A specific form of IOC, DI allows Spring to automatically provide the necessary dependencies to classes. 
For example, if a UserController requires a UserService, Spring will inject the UserService instance without 
the need for the controller to instantiate it manually 

### What is the IOC container?
This core component of the Spring framework manages all beans and performs dependency injection. It ensures 
that beans are created and destroyed at the appropriate times 
* part of the core of the Spring Framework
* responsible for managing all the beans
* performs dependency injection 

### What is the Application context?
Imagine you have a toy box (the Application Context) that keeps all your toys (your beans) organized. If you 
want to play with a toy, you don't need to search for it yourself; you ask the toy box, and it gives you the right one.

### What does  @SpringBootApplication do?
@SpringBootApplication is a convenience annotation in Spring Boot that combines three annotations:
* @EnableAutoConfiguration: Automatically configures Spring application based on dependencies.
* @ComponentScan: Scans the package for Spring components (like @Controller, @Service, etc.).
* @Configuration: Marks the class as a source of bean definitions.


### What is the Dispatch Servlet?
The DispatcherServlet in Spring MVC acts as the front controller. It handles all incoming HTTP requests and 
routes them to the appropriate components (like controllers). It integrates different parts of the Spring framework, 
including views, models, and controllers, to process the request and generate the response.
* Receives and delegates requests.
* Interacts with controller logic.
* Selects the view for the response.

### What is a Logger?
A Logger in programming, particularly in frameworks like Java's Log4j or SLF4J, is a tool used to record messages 
about an application's execution. These messages, known as logs, can provide information for debugging, monitoring, 
or tracking an application's behavior.

