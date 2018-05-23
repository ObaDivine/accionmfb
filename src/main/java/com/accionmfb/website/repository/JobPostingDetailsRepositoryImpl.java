/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accionmfb.website.repository;

import com.accionmfb.website.model.JobPostingDetails;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
public class JobPostingDetailsRepositoryImpl implements JobPostingDetailsRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<JobPostingDetails> getJobResponsibilities(String jobId) {
        TypedQuery<JobPostingDetails> query = em.createQuery("SELECT j FROM JobPostingDetails AS j WHERE j.jobDetailsType = :jobDetailsType AND j.jobPosting.jobId = :jobId",JobPostingDetails.class)
                .setParameter("jobDetailsType", "Responsibility")
                .setParameter("jobId", Long.parseLong(jobId));
        return query.getResultList();
    }

    @Override
    public List<JobPostingDetails> getJobKnowledge(String jobId) {
        TypedQuery<JobPostingDetails> query = em.createQuery("SELECT j FROM JobPostingDetails AS j WHERE j.jobDetailsType = :jobDetailsType AND j.jobPosting.jobId = :jobId",JobPostingDetails.class)
                .setParameter("jobDetailsType", "Knowledge")
                .setParameter("jobId", Long.parseLong(jobId));
        return query.getResultList();
    }

    @Override
    public List<JobPostingDetails> getJobQualifications(String jobId) {
        TypedQuery<JobPostingDetails> query = em.createQuery("SELECT j FROM JobPostingDetails AS j WHERE j.jobDetailsType = :jobDetailsType AND j.jobPosting.jobId = :jobId",JobPostingDetails.class)
                .setParameter("jobDetailsType", "Qualification")
                .setParameter("jobId", Long.parseLong(jobId));
        return query.getResultList();
    }

    @Override
    public List<JobPostingDetails> getJobKeyPerformance(String jobId) {
        TypedQuery<JobPostingDetails> query = em.createQuery("SELECT j FROM JobPostingDetails AS j WHERE j.jobDetailsType = :jobDetailsType AND j.jobPosting.jobId = :jobId",JobPostingDetails.class)
                .setParameter("jobDetailsType", "Performance")
                .setParameter("jobId", Long.parseLong(jobId));
        return query.getResultList();
    }
    
}
