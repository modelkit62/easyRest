# easyRest

- SpringRunner is an alias for the SpringJUnit4ClassRunner. It is a custom extension of JUnit’s BlockJUnit4ClassRunner which provides functionality of the Spring TestContext Framework to standard JUnit tests by means of the TestContextManager and associated support classes and annotations.

- @WebMvcTest annotation is used for Spring MVC tests. It disables full auto-configuration and instead apply only configuration relevant to MVC tests.

- The WebMvcTest annotation auto-configure MockMvc instance as well.

- Using EmployeeRESTController.class as parameter, we are asking to initialize only one web controller and you need to provide remaining dependencies required using Mock objects.
