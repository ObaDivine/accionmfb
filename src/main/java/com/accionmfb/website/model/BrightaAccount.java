/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accionmfb.website.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
@Entity
@Table(name = "account_request")
public class BrightaAccount implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    
    @NotEmpty
    @NotNull
    @Column(name = "product_type", nullable = false)
    private String productType;
    
    @NotEmpty
    @NotNull
    @Column(name = "surname", nullable = false)
    private String surname;
    
    @NotEmpty
    @NotNull
    @Column(name = "firstName", nullable = false)
    private String firstName;
    
    @NotEmpty
    @NotNull
    @Column(name = "middleName", nullable = false)
    private String middleName;
    
    @NotEmpty
    @NotNull
    @Column(name = "gender", nullable = false)
    private String gender;
    
    @NotEmpty
    @NotNull
    @Column(name = "state_of_origin", nullable = false)
    private String stateOfOrigin;
    
    @NotEmpty
    @NotNull
    @Column(name = "town", nullable = false)
    private String town;
    
    @NotEmpty
    @NotNull
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    
    @NotEmpty
    @NotNull
    @Column(name = "date_of_birth", nullable = false)
    private String doB;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStateOfOrigin() {
        return stateOfOrigin;
    }

    public void setStateOfOrigin(String stateOfOrigin) {
        this.stateOfOrigin = stateOfOrigin;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDoB() {
        return doB;
    }

    public void setDoB(String doB) {
        this.doB = doB;
    } 
    
}
