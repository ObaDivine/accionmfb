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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
@Entity
@Table(name = "job_application")
public class JobApplication implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long jobApplicationId;
    
    @ManyToOne()
    private JobPosting jobPosting;
    
    @NotNull
    @Column(name = "title", nullable = false)
    private String title;
    
    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @NotNull
    @Column(name = "middle_name", nullable = true)
    private String middleName;
    
    @NotNull
    @Column(name = "last_name")
    private String lastName;
    
    @NotNull
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    
    @NotNull
    @Column(name = "home_phone", nullable = true)
    private String homePhone;
    
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;
    
    @NotNull
    @Column(name = "residential_address", nullable = false)
    private String residentialAddress;
    
    @NotNull
    @Column(name = "date_of_birth", nullable = false)
    private String doB;
    
    @NotNull
    @Column(name = "gender", nullable = false)
    private String gender;
    
    @NotNull
    @Column(name = "marital_status", nullable = false)
    private String maritalStatus;
    
    @NotNull
    @Column(name = "state_of_origin", nullable = false)
    private String stateOfOrigin;
    
    @NotNull
    @Column(name = "location", nullable = false)
    private String location;
    
    @NotNull
    @Column(name = "state_of_residence", nullable = false)
    private String stateOfResidence;
    
    @NotNull
    @Column(name = "course_of_study", nullable = false)
    private String courseOfStudy;
    
    @NotNull
    @Column(name = "school_name", nullable = false)
    private String schoolName;
    
    @NotNull
    @Column(name = "graduation_year", nullable = false)
    @Size(min = 4, max = 4)
    private String graduationYear;
    
    @NotNull
    @Column(name = "first_degree", nullable = false)
    private String firstDegree;
    
    @NotNull
    @Column(name = "second_degree", nullable = true)
    private String secondDegree;
    
    @NotNull
    @Column(name = "nysc_year", nullable = false)
    @Size(min = 4, max = 4)
    private String nyscYear;
    
    @NotNull
    @Column(name = "years_of_experience", nullable = false)
    @Size(min = 4, max = 4)
    private String yearsOfExperience;
    
    @NotNull
    @Column(name = "years_of_bank_experience", nullable = false)
    @Size(min = 4, max = 4)
    private String yearsOfBankExperience;
    
    @NotNull
    @Column(name = "current_employer", nullable = true)
    private String currentEmployer;
    
    @NotNull
    @Column(name = "current_job_role", nullable = true)
    private String currentJobRole;
    
    @NotNull
    @Column(name = "previous_employer", nullable = true)
    private String previuosEmployer;
    
    @NotNull
    @Column(name = "position_applied", nullable = false)
    private String positionApplied;
    
    @NotNull
    @Column(name = "salary", nullable = false)
    private float salary;
    
    @NotNull
    @Column(name = "grade")
    private String grade;
    
    @NotNull
    @Column(name = "first_reference_name", nullable = false)
    private String firstReferenceName;
    
    @NotNull
    @Column(name = "first_reference_phone", nullable = false)
    private String firstReferencePhone;
    
    @NotNull
    @Column(name = "first_reference_email", nullable = true)
    private String firstReferenceEmail;
    
    @NotNull
    @Column(name = "second_reference_name", nullable = false)
    private String secondReferenceName;
    
    @NotNull
    @Column(name = "second_reference_phone", nullable = false)
    private String secondReferencePhone;
    
    @NotNull
    @Column(name = "second_reference_email", nullable = true)
    private String secondReferenceEmail;

    public Long getJobApplicationId() {
        return jobApplicationId;
    }

    public void setJobApplicationId(Long jobApplicationId) {
        this.jobApplicationId = jobApplicationId;
    }

    public JobPosting getJobPosting() {
        return jobPosting;
    }

    public void setJobPosting(JobPosting jobPosting) {
        this.jobPosting = jobPosting;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public String getDoB() {
        return doB;
    }

    public void setDoB(String doB) {
        this.doB = doB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getStateOfOrigin() {
        return stateOfOrigin;
    }

    public void setStateOfOrigin(String stateOfOrigin) {
        this.stateOfOrigin = stateOfOrigin;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStateOfResidence() {
        return stateOfResidence;
    }

    public void setStateOfResidence(String stateOfResidence) {
        this.stateOfResidence = stateOfResidence;
    }

    public String getCourseOfStudy() {
        return courseOfStudy;
    }

    public void setCourseOfStudy(String courseOfStudy) {
        this.courseOfStudy = courseOfStudy;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getFirstDegree() {
        return firstDegree;
    }

    public void setFirstDegree(String firstDegree) {
        this.firstDegree = firstDegree;
    }

    public String getSecondDegree() {
        return secondDegree;
    }

    public void setSecondDegree(String secondDegree) {
        this.secondDegree = secondDegree;
    }

    public String getNyscYear() {
        return nyscYear;
    }

    public void setNyscYear(String nyscYear) {
        this.nyscYear = nyscYear;
    }

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getYearsOfBankExperience() {
        return yearsOfBankExperience;
    }

    public void setYearsOfBankExperience(String yearsOfBankExperience) {
        this.yearsOfBankExperience = yearsOfBankExperience;
    }

    public String getCurrentEmployer() {
        return currentEmployer;
    }

    public void setCurrentEmployer(String currentEmployer) {
        this.currentEmployer = currentEmployer;
    }

    public String getCurrentJobRole() {
        return currentJobRole;
    }

    public void setCurrentJobRole(String currentJobRole) {
        this.currentJobRole = currentJobRole;
    }

    public String getPreviuosEmployer() {
        return previuosEmployer;
    }

    public void setPreviuosEmployer(String previuosEmployer) {
        this.previuosEmployer = previuosEmployer;
    }

    public String getPositionApplied() {
        return positionApplied;
    }

    public void setPositionApplied(String positionApplied) {
        this.positionApplied = positionApplied;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getFirstReferenceName() {
        return firstReferenceName;
    }

    public void setFirstReferenceName(String firstReferenceName) {
        this.firstReferenceName = firstReferenceName;
    }

    public String getFirstReferencePhone() {
        return firstReferencePhone;
    }

    public void setFirstReferencePhone(String firstReferencePhone) {
        this.firstReferencePhone = firstReferencePhone;
    }

    public String getFirstReferenceEmail() {
        return firstReferenceEmail;
    }

    public void setFirstReferenceEmail(String firstReferenceEmail) {
        this.firstReferenceEmail = firstReferenceEmail;
    }

    public String getSecondReferenceName() {
        return secondReferenceName;
    }

    public void setSecondReferenceName(String secondReferenceName) {
        this.secondReferenceName = secondReferenceName;
    }

    public String getSecondReferencePhone() {
        return secondReferencePhone;
    }

    public void setSecondReferencePhone(String secondReferencePhone) {
        this.secondReferencePhone = secondReferencePhone;
    }

    public String getSecondReferenceEmail() {
        return secondReferenceEmail;
    }

    public void setSecondReferenceEmail(String secondReferenceEmail) {
        this.secondReferenceEmail = secondReferenceEmail;
    }
    
    
}
