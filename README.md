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


https://reflectoring.io/spring-boot-exception-handling/


### @ResponseStatus
As the name suggests, @ResponseStatus allows us to modify the HTTP status of our response. It can be applied in the following places:

* On the exception class itself
* Along with the @ExceptionHandler annotation on methods
* Along with the @ControllerAdvice annotation on classes

```
@ResponseStatus(value = HttpStatus.NOT_FOUND)
```

### @ExceptionHandler
The @ExceptionHandler annotation gives us a lot of flexibility in terms of handling exceptions.


Now, let’s finalize an error response payload for our APIs. In case of any error, clients usually expect two things:

* An error code that tells the client what kind of error it is. Error codes can be used by clients in their code to drive some business logic based on it. Usually, error codes are standard HTTP status codes, but I have also seen APIs returning custom errors code likes E001.

* An additional human-readable message which gives more information on the error and even some hints on how to fix them or a link to API docs.


### @ResponseEntityExceptionHandler

ResponseEntityExceptionHandler is a convenient base class for controller advice classes. It provides exception handlers for internal Spring exceptions. If we don’t extend it, then all the exceptions will be redirected to DefaultHandlerExceptionResolver which returns a ModelAndView object.

Handling NoHandlerFoundException Requires a Few Extra Steps
This exception occurs when you try to call an API that doesn't exist in the system. Despite us implementing its handler via ResponseEntityExceptionHandler class the exception is redirected to DefaultHandlerExceptionResolver.

### Some Points to Keep in Mind when Using @ControllerAdvice

* To keep things simple always have only one controller advice class in the project. It’s good to have a single repository of all the exceptions in the application. In case you create multiple controller advice, try to utilize the basePackages or annotations properties to make it clear what controllers it’s going to advise.
* Spring can process controller advice classes in any order unless we have annotated it with the @Order annotation. So, be mindful when you write a catch-all handler if you have more than one controller advice. Especially when you have not specified basePackages or annotations in the annotation.


@RequestParam binds the value of the query string parameter name into the name parameter of the greeting() method. If the name parameter is absent in the request, the defaultValue of World is used.

The implementation of the method body creates and returns a new Greeting object with id and content attributes based on the next value from the counter and formats the given name by using the greeting template.

A key difference between a traditional MVC controller and the RESTful web service controller shown earlier is the way that the HTTP response body is created. Rather than relying on a view technology to perform server-side rendering of the greeting data to HTML, this RESTful web service controller populates and returns a Greeting object. The object data will be written directly to the HTTP response as JSON.
