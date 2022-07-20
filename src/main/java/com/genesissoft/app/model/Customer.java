package com.genesissoft.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int customerId;
    @Column(length = 15)
    private String title;
    @Column(length = 55, nullable = false)
    private String firstName;
    @Column(length = 55, nullable = false)
    private String middleName;
    @Column(length = 55, nullable = false)
    private String lastName;
    @Column(length = 65)
    private String companyName;
    @Column(length = 55, nullable = false)
    private String emailAddress;
}
