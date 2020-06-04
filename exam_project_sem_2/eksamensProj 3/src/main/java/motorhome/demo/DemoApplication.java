package motorhome.demo;

import motorhome.demo.controllers.MotorhomeController;
import motorhome.demo.models.Motorhome;
import motorhome.demo.repositories.EmployeeRepositoryImpl;
import motorhome.demo.repositories.MotorhomeRepositoryImpl;
import motorhome.demo.repositories.RentalRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
   }
}