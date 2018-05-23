/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accionmfb.website.controller;

import com.accionmfb.website.model.Internship;
import com.accionmfb.website.service.AccionMFBServices;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
@Controller
@RequestMapping(value = "/career")
public class CareerController {

    @Autowired
    private AccionMFBServices accionMFBServices;

    @RequestMapping(value = "/career-at-accion", method = RequestMethod.GET)
    public String career() {
        return "careerhome";
    }

    @RequestMapping(value = "/featured-positions", method = RequestMethod.GET)
    public String featuredPositions(Model model) {
        //Retrieve all the job vacancies still open
        model.addAttribute("openVacancies", accionMFBServices.getOpenJobPostings());
        return "openvacancies";
    }

    @RequestMapping(value = "/internship", method = RequestMethod.GET)
    public String internship(Internship internship, Model model) {
        Internship form = new Internship();
        model.addAttribute("internshipForm", form);

        List<String> genders = new ArrayList<>();
        genders.add("Female");
        genders.add("Male");
        model.addAttribute("genders", genders);

        List<String> states = new ArrayList<>();
        states.add("Abia");
        states.add("Adamawa");
        model.addAttribute("statesInNigeria", states);
        return "internship";
    }

    @RequestMapping(value = "/apply-for-internship", method = RequestMethod.POST)
    public String internshipFormSubmit(@RequestAttribute("employee") Internship internship, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "internship";
        }
        return "internship";
    }

    @RequestMapping(value = "/career-path", method = RequestMethod.GET)
    public String careerPath() {
        return "careerpath";
    }

    @RequestMapping(value = "/accion-community", method = RequestMethod.GET)
    public String careerCommunity() {
        return "careercommunity";
    }

    @RequestMapping(value = "/job-details/{jobId}", method = RequestMethod.GET)
    public String jobDetails(@PathVariable String jobId, Model model) {
        //Retrieve all the details about a particular job position
        model.addAttribute("jobResponsibilities", accionMFBServices.getJobResponsibilities(jobId));
        model.addAttribute("jobKnowledge", accionMFBServices.getJobKnowledge(jobId));
        model.addAttribute("jobQualification", accionMFBServices.getJobQualifications(jobId));
        model.addAttribute("jobKeyPerformance", accionMFBServices.getJobKeyPerformance(jobId));
        return "jobdetails";
    }

}
