package com.genesissoft.app.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private int customerId;
    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    private String companyName;
    private String emailAddress;
}
