package javagyakorlat.pizzatime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("javagyakorlat.pizzatime.controller")
@ComponentScan("javagyakorlat.pizzatime.config")
public class PizzaTimeApplication {
    public static void main(String[] args) {
        SpringApplication.run(PizzaTimeApplication.class, args);
    }
}
