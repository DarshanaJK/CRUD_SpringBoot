package com.project.CRUD_SpringBoot.controller;

import com.project.CRUD_SpringBoot.entity.Customer;
import com.project.CRUD_SpringBoot.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/customer")
    public Customer postCustomer(@RequestBody Customer customer){
        return customerService.postCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        Customer customer = customerService.getCustomerById(id);
        if (customer == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(customer);
        }
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        Customer existingCustomer = customerService.getCustomerById(id);

        if (existingCustomer == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }else{
            existingCustomer.setName(customer.getName());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setPhone(customer.getPhone());

            Customer updatedCustomer = customerService.updateCustomer(existingCustomer);
            return ResponseEntity.status(HttpStatus.OK).body(updatedCustomer);
        }
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        Customer customer = customerService.getCustomerById(id);

        if (customer == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }else{
            customerService.deleteCustomer(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }
}
