/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accionmfb.website.repository;

import com.accionmfb.website.model.JobPostingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
public interface JobPostingDetailsRepository extends JpaRepository<JobPostingDetails, Long>, JobPostingDetailsRepositoryCustom{
    
}
