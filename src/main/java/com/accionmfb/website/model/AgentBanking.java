/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accionmfb.website.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
@Entity
@Table(name = "agent_request")
public class AgentBanking implements Serializable {

    @Id
    @Column(name = "agent_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    
    @Column(name = "surname", nullable = false, unique = false)
    @NotEmpty
    @NotNull
    private String surname;
    
    @Column(name = "other_names", nullable = false, unique = false)
    @NotEmpty
    @NotNull
    private String otherNames;
    
    @Column(name = "phone_number", nullable = false, unique = true)
    @NotEmpty
    @NotNull
    private String phoneNumber;
    
    @Column(name = "contact_address", nullable = false, unique = false)
    @NotEmpty
    @NotNull
    private String contactAddress;
    
    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotEmpty
    private String email;
    
    @Column(name = "gender", nullable = false)
    @NotEmpty
    private String gender;
    
    @Column(name = "dob", nullable = false, unique = true)
    //@DateTimeFormat(iso=ISO.DATE, pattern = "MM-dd-yyyy")
    private String doB;
    
    @Column(name = "business_name", nullable = false, unique = false)
    @NotEmpty
    private String businessName;
    
    @Column(name = "business_address", nullable = false, unique = false)
    @NotEmpty
    @NotNull
    private String businessAddress;
    
    @Column(name = "business_state", nullable = false, unique = false)
    @NotEmpty
    @NotNull
    private String businessState;
    
    @Column(name = "business_lga", nullable = false, unique = false)
    @NotEmpty
    @NotNull
    private String businessLGA;
    
    @Column(name = "company_reg", nullable = false, unique = true)
    @NotEmpty
    @NotNull
    private String companyRegNo;
    
    @Column(name = "business_type", nullable = false, unique = false)
    @NotEmpty
    @NotNull
    private String businessType;
    
    @Column(name = "trans_date", nullable = false)
    private Date transDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDoB() {
        return doB;
    }

    public void setDoB(String doB) {
        this.doB = doB;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessState() {
        return businessState;
    }

    public void setBusinessState(String businessState) {
        this.businessState = businessState;
    }

    public String getBusinessLGA() {
        return businessLGA;
    }

    public void setBusinessLGA(String businessLGA) {
        this.businessLGA = businessLGA;
    }

    public String getCompanyRegNo() {
        return companyRegNo;
    }

    public void setCompanyRegNo(String companyRegNo) {
        this.companyRegNo = companyRegNo;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

}
