/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accionmfb.website.repository;

import com.accionmfb.website.model.JobPosting;
import java.util.List;

/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
public interface JobPostingRepositoryCustom {
    List<JobPosting> getOpenJobPostings();
    List<JobPosting> getClosedJobPostings();
    List<JobPosting> getAllJobPostings();
}
