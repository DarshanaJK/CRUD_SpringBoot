package com.project.CRUD_SpringBoot.service;

import com.project.CRUD_SpringBoot.entity.Customer;
import com.project.CRUD_SpringBoot.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer postCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
