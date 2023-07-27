package com.NoobCoders.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Transactional
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student")
@ToString
public class Student {

    @Id
    @GeneratedValue(generator = "increment")
    private Integer id;

    @Column(name = "f_name")
    private String firstName;

    @Column(name = "l_name")
    private String lastName;

    @Column(name = "dob")
    private String dob;

    @Column(name = "parent_name")
    private String parentName;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "phone")
    private String phoneNumber;
    
//    private Integer discontinued;

	
    // Constructors, getters, and setters
    
    
}

