package com.genesissoft.app.service.impl;

import com.genesissoft.app.dto.CustomerDto;
import com.genesissoft.app.model.Customer;
import com.genesissoft.app.repository.CustomerRepository;
import com.genesissoft.app.service.abstr.CustomerService;
import com.genesissoft.app.util.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerServiceImpl implements CustomerService {

    private ModelMapper modelMapper = Utils.getMapper();

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customerToSave = modelMapper.map(customerDto, Customer.class);
        Customer customerSaved = customerRepository.save(customerToSave);
        CustomerDto customerDtoResponse = modelMapper.map(customerSaved, CustomerDto.class);
        return customerDtoResponse;
    }

    @Override
    public CustomerDto findById(int id) {
        Optional<Customer> customerSearch = customerRepository.findById(id);
        if (customerSearch.isPresent()) {
            Customer customer = customerRepository.findById(id).get();
            CustomerDto customerDtoResponse = modelMapper.map(customer, CustomerDto.class);
            return customerDtoResponse;
        } else {
            return null;
        }
    }

    @Override
    public CustomerDto updateCustomerById(int id, CustomerDto customerDto) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteCustomer(int id) {
        return null;
    }

    @Override
    public Page<CustomerDto> findAll(int pageNo, int pageSize, String sortBy, String ordered) {
        if (ordered.equalsIgnoreCase("asc")) {
            Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
            Page<Customer> pageCustomer = customerRepository.findAll(pageable);
            List<CustomerDto> customerResponse = new ArrayList<>();
            List<Customer> customerList = pageCustomer.getContent();
            customerList.stream().forEach(customer -> {
                CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
                customerResponse.add(customerDto);
            });
            Page<CustomerDto> pageCustomerResponse = new PageImpl<CustomerDto>(customerResponse, pageable,
                customerResponse.size());
            return pageCustomerResponse;
        } else {
            Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
            Page<Customer> pageCustomer = customerRepository.findAll(pageable);
            List<CustomerDto> customerResponse = new ArrayList<>();
            List<Customer> customerList = pageCustomer.getContent();
            customerList.stream().forEach(customer -> {
                CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
                customerResponse.add(customerDto);
            });
            Page<CustomerDto> pageCustomerResponse = new PageImpl<CustomerDto>(customerResponse, pageable,
                customerResponse.size());
            return pageCustomerResponse;
        }
    }
}
