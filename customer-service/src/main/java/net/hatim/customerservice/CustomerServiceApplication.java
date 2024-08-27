package net.hatim.customerservice;

import net.hatim.customerservice.entities.Customer;
import net.hatim.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            List<Customer> customerList = List.of(
                    Customer.builder()
                            .firstName("Hassan")
                            .lastName("el")
                            .email("hassan@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("Hassan2")
                            .lastName("el2")
                            .email("hassan2@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("Hassan3")
                            .lastName("el3")
                            .email("hassan3@gmail.com")
                            .build()
            );
            customerRepository.saveAll(customerList);
        };
    }
}
