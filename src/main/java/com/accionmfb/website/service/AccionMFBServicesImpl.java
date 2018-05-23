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
import com.accionmfb.website.repository.AccountRepository;
import com.accionmfb.website.repository.ContactUsRepository;
import com.accionmfb.website.repository.JobApplicationRepository;
import com.accionmfb.website.repository.JobPostingDetailsRepository;
import com.accionmfb.website.repository.JobPostingRepository;
import com.accionmfb.website.repository.LoanRepository;
import com.accionmfb.website.repository.StatesAndLGAsRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
@Service
public class AccionMFBServicesImpl implements AccionMFBServices {

    @Autowired
    private StatesAndLGAsRepository statesAndLGAsRepository;

    @Autowired
    private ContactUsRepository contactUsRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JobPostingRepository jobPostingRepository;

    @Autowired
    private JobPostingDetailsRepository jobPostingDetailsRepository;

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Override
    public List<States> getStates() {
        return statesAndLGAsRepository.getStates();
    }

    @Override
    public List<States> getStateLGAs(String state) {
        return statesAndLGAsRepository.getStateLGAs(state);
    }

    @Override
    public List<States> getLGAs() {
        return statesAndLGAsRepository.getLGAs();
    }

    @Override
    public ContactUs createContactUs(ContactUs contactDetail) {
        return contactUsRepository.saveAndFlush(contactDetail);
    }

    @Override
    public List<String> subjectCategories() {
        List<String> subjectCategories = new ArrayList<>();
        subjectCategories.add("Debit Card Issue");
        subjectCategories.add("Account Opening");
        subjectCategories.add("Request For Loan");
        subjectCategories.add("Loan Restructuring");
        return subjectCategories;
    }

    @Override
    public List<String> businessTypes() {
        List<String> businessType = new ArrayList<>();
        businessType.add("Sole Proprietorship");
        businessType.add("Limited Liability Company");
        businessType.add("Public Liability Company");
        return businessType;
    }

    @Override
    public List<String> genders() {
        List<String> genders = new ArrayList<>();
        genders.add("Female");
        genders.add("Male");
        return genders;
    }

    //This section handles product related processes
    @Override
    public String createBrightaAccount(BrightaAccount brightaAccount) {
        BrightaAccount accountExist = accountRepository.findByPhoneNumber(brightaAccount.getPhoneNumber());
        if (accountExist != null) {
            return "Account details already exist";
        }
        accountRepository.saveAndFlush(brightaAccount);
        return "Account created successfully";
    }

    @Override
    public BrightaLoan createBrightaLoan(BrightaLoan brightaLoan) {

        return loanRepository.saveAndFlush(brightaLoan);
    }

    @Override
    public List<JobPosting> getOpenJobPostings() {
        return jobPostingRepository.getOpenJobPostings();
    }

    @Override
    public List<JobPosting> getClosedJobPostings() {
        return jobPostingRepository.getClosedJobPostings();
    }

    @Override
    public List<JobPosting> getAllJobPostings() {
        return jobPostingRepository.getAllJobPostings();
    }

    @Override
    public String createJobPosting(JobPosting jobPosting) {
        JobPosting job = jobPostingRepository.saveAndFlush(jobPosting);

        if (job != null) {
            return "success";
        }
        return "failed";
    }

    @Override
    public String applyForJob(JobApplication jobApplication) {
        JobApplication job = jobApplicationRepository.saveAndFlush(jobApplication);

        if (job != null) {
            return "success";
        }
        return "failed";
    }


    @Override
    public List<JobPostingDetails> getJobResponsibilities(String jobId) {
        return jobPostingDetailsRepository.getJobResponsibilities(jobId);
    }

    @Override
    public List<JobPostingDetails> getJobKnowledge(String jobId) {
        return jobPostingDetailsRepository.getJobKnowledge(jobId);
    }

    @Override
    public List<JobPostingDetails> getJobQualifications(String jobId) {
       return jobPostingDetailsRepository.getJobQualifications(jobId);
    }

    @Override
    public List<JobPostingDetails> getJobKeyPerformance(String jobId) {
       return jobPostingDetailsRepository.getJobKeyPerformance(jobId);
    }
    
    
}
