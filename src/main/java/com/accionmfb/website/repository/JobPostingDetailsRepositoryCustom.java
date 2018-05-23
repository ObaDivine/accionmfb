/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accionmfb.website.repository;

import com.accionmfb.website.model.JobPostingDetails;
import java.util.List;

/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
public interface JobPostingDetailsRepositoryCustom {
    List<JobPostingDetails> getJobResponsibilities(String jobId);
    List<JobPostingDetails> getJobKnowledge(String jobId);
    List<JobPostingDetails> getJobQualifications(String jobId);
    List<JobPostingDetails> getJobKeyPerformance(String jobId);
}
