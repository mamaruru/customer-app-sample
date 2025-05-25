package com.example.customerapp;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.domain.Specification;

public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
}
