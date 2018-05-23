/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accionmfb.website.service;

import com.accionmfb.website.model.BrightaAccount;
import com.accionmfb.website.model.BrightaLoan;
import com.accionmfb.website.model.ContactUs;
import com.accionmfb.website.model.JobApplication;
import com.accionmfb.website.model.JobPosting;
import com.accionmfb.website.model.JobPostingDetails;
import com.accionmfb.website.model.States;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
@Service
public interface AccionMFBServices{
    List<States> getStates();
    List<States> getStateLGAs(String state);
    List<States> getLGAs();
    ContactUs createContactUs(ContactUs contactDetail);
    List<String> subjectCategories();
    List<String> businessTypes();
    List<String> genders();
    
    //Products related section
    String createBrightaAccount(BrightaAccount brightaAccount);
    BrightaLoan createBrightaLoan(BrightaLoan brightaLoan);
    
    //Career related section
    
    List<JobPosting> getOpenJobPostings();
    List<JobPosting> getClosedJobPostings();
    List<JobPosting> getAllJobPostings();
    String createJobPosting(JobPosting jobPosting);
    String applyForJob(JobApplication jobApplication);
    List<JobPostingDetails> getJobResponsibilities(String jobId);
    List<JobPostingDetails> getJobKnowledge(String jobId);
    List<JobPostingDetails> getJobQualifications(String jobId);
    List<JobPostingDetails> getJobKeyPerformance(String jobId);
}
