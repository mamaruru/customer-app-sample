package com.example.customerapp;

import org.springframework.data.jpa.domain.Specification;
import java.time.LocalDate;

public class CustomerSpecifications {
    public static Specification<Customer> nameContains(String keyword) {
        return (root, query, cb) -> (keyword == null || keyword.isEmpty()) ? null : cb.like(root.get("name"), "%" + keyword + "%");
    }
    public static Specification<Customer> addressContains(String keyword) {
        return (root, query, cb) -> (keyword == null || keyword.isEmpty()) ? null : cb.like(root.get("address"), "%" + keyword + "%");
    }
    public static Specification<Customer> birthDateEquals(LocalDate date) {
        return (root, query, cb) -> (date == null) ? null : cb.equal(root.get("birthDate"), date);
    }
}
