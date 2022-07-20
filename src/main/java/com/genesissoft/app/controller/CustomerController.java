package com.genesissoft.app.controller;

import com.genesissoft.app.dto.CustomerDto;
import com.genesissoft.app.service.abstr.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<Page<CustomerDto>> getAllPersonages(
        @RequestParam(name = "page", defaultValue = "0") int page,
        @RequestParam(name = "size", defaultValue = "5") int size,
        @RequestParam(name = "sortBy", defaultValue = "customerId") String sortBy,
        @RequestParam(name = "ordered", defaultValue = "asc") String ordered) {
        Page<CustomerDto> customers = customerService.findAll(page, size, sortBy, ordered);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerDto> getAllPersonages(@RequestBody CustomerDto customer) {
        CustomerDto customerResponse = customerService.createCustomer(customer);
        return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
    }

    @GetMapping(path = "/customers", params = "id")
    public ResponseEntity<CustomerDto> searchById(@RequestParam(value = "id") int id) {
        CustomerDto customerResponse = customerService.findById(id);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }
}
