package net.hatim.customerservice.web;


import net.hatim.customerservice.entities.Customer;
import net.hatim.customerservice.repository.CustomerRepository;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
@RefreshScope
@RequestMapping("/api")
public class CustomerRestController {

    private CustomerRepository customerRepository;


    public CustomerRestController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer customerById(@PathVariable Long id){
        return customerRepository.findById(id).get();
    }
}
