package com.example.customerapp;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public String listCustomers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "asc") String sortDir,
            Model model
    ) {
        log.info("検索条件: name={}, address={}, birthDate={}", name, address, birthDate);

        Specification<Customer> spec = Specification.where(CustomerSpecifications.nameContains(name))
                .and(CustomerSpecifications.addressContains(address))
                .and(CustomerSpecifications.birthDateEquals(birthDate));

        Sort sort = sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        List<Customer> customers = customerRepository.findAll(spec, sort);

        model.addAttribute("customers", customers);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("name", name);
        model.addAttribute("address", address);
        model.addAttribute("birthDate", birthDate);
        return "customer/list";
    }
}
