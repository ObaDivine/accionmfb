/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accionmfb.website.repository;

import com.accionmfb.website.model.JobPosting;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
public class JobPostingRepositoryImpl implements JobPostingRepositoryCustom{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<JobPosting> getOpenJobPostings() {
        //Returns all job posting that are still open. Use the Status field to determine
        TypedQuery<JobPosting> query;
        query = em.createQuery("SELECT j FROM JobPosting AS j WHERE j.status = 'Open'", JobPosting.class);
        return query.getResultList();
    }

    @Override
    public List<JobPosting> getClosedJobPostings() {
        //Return all closed jobs based on the status
        TypedQuery<JobPosting> query;
        query = em.createQuery("SELECT j FROM JobPosting AS j WHERE j.status = 'Closed'", JobPosting.class);
        return query.getResultList();
    }

    @Override
    public List<JobPosting> getAllJobPostings() {
        //Return all job postings irrespective of status
        TypedQuery<JobPosting> query;
        query = em.createQuery("SELECT j FROM JobPosting AS j", JobPosting.class);
        return query.getResultList();
    }
   
}
