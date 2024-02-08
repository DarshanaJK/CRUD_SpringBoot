package com.project.CRUD_SpringBoot.repository;

import com.project.CRUD_SpringBoot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
