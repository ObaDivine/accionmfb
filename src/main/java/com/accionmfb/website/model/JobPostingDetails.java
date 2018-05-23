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

/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
@Entity
@Table(name = "job_details")
public class JobPostingDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long jobDetailsId;

    @ManyToOne()
    private JobPosting jobPosting;

    @NotNull
    @Column(name = "job_details_type", nullable = false)
    private String jobDetailsType;

    @NotNull
    @Column(name = "job_details_description", nullable = false)
    private String jobDetails;

    public Long getJobDetailsId() {
        return jobDetailsId;
    }

    public void setJobDetailsId(Long jobDetailsId) {
        this.jobDetailsId = jobDetailsId;
    }

    public JobPosting getJobPosting() {
        return jobPosting;
    }

    public void setJobPosting(JobPosting jobPosting) {
        this.jobPosting = jobPosting;
    }

    public String getJobDetailsType() {
        return jobDetailsType;
    }

    public void setJobDetailsType(String jobDetailsType) {
        this.jobDetailsType = jobDetailsType;
    }

    public String getJobDetails() {
        return jobDetails;
    }

    public void setJobDetails(String jobDetails) {
        this.jobDetails = jobDetails;
    }
    
    
}
