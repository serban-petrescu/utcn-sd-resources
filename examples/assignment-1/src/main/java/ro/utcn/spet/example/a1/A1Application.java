package ro.utcn.spet.example.a1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// this annotation enables component scanning: all the classes in this package and its subpackages which are
// annotated with @Component (or any of its specializations) are considered for dependency injection
// https://www.baeldung.com/spring-component-scanning
// https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-spring-beans-and-dependency-injection.html
@SpringBootApplication
public class A1Application {

	public static void main(String[] args) {
		// this "bootstraps" the Spring Framework and transfers control to it; from now on, we will need to
		// use Spring mechanisms (CommandLineRunners, Controllers) to obtain control and execute something
		SpringApplication.run(A1Application.class, args);
	}

}
