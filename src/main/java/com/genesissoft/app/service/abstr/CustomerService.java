package com.genesissoft.app.service.abstr;

import com.genesissoft.app.dto.CustomerDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto findById(int id);

    CustomerDto updateCustomerById(int id, CustomerDto customerDto);

    ResponseEntity<?> deleteCustomer(int id);

    Page<CustomerDto> findAll(int pageNo, int pageSize, String sortBy, String ordered);
}
