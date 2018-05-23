/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accionmfb.website.controller;

import com.accionmfb.website.model.ContactUs;
import com.accionmfb.website.service.AccionMFBServices;
import java.util.Locale;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
@Controller
@RequestMapping(value = "/contact")
public class ContactController {
    
    @Autowired
    private final AccionMFBServices accionMFBServices;
    
    @Autowired
    MessageSource messageSource;
    
    public ContactController(AccionMFBServices accionMFBServices) {
        this.accionMFBServices = accionMFBServices;
    }
    
    @RequestMapping(value = "/contact-us", method = RequestMethod.GET)
    public String contactUs(Model model) {
        model.addAttribute("contactUsForm", new ContactUs());
        model.addAttribute("enquiryCategories", accionMFBServices.subjectCategories());
        return "contactushome";
    }

    @RequestMapping(value = "/submit-contact-form", method = RequestMethod.POST)
    public String createContactUs(@Valid ContactUs contactDetails, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("enquiryCategories", accionMFBServices.subjectCategories());
            return "contactus";
        }

        ContactUs message = accionMFBServices.createContactUs(contactDetails);
        if (message != null) {
            //Create a fresh model form without values
            model.addAttribute("enquiryCategories", accionMFBServices.subjectCategories());
            model.addAttribute("contactUsForm", new ContactUs());

            //Add message (success or falure) to model
            model.addAttribute("message", "success");

            return "contactus";
        }
        //The setion indicates that the app failed to create the contact form
        model.addAttribute("message", messageSource.getMessage("applicationMessages.failed", new Object[0], Locale.ENGLISH));
        model.addAttribute("enquiryCategories", accionMFBServices.subjectCategories());
        model.addAttribute("contactUsForm", new ContactUs());
        return "contactus";
    }

    @RequestMapping(value = "/branch-network", method = RequestMethod.GET)
    public String branchNetwork(Model model) {
        return "branchnetwork";
    }

    @RequestMapping(value = "/atm-network", method = RequestMethod.GET)
    public String atmNetwork(Model model) {
        return "atmnetwork";
    }

    @RequestMapping(value = "/frequently-asked-questions", method = RequestMethod.GET)
    public String faq(Model model) {
        return "faq";
    }

    @RequestMapping(value = "/feedback", method = RequestMethod.GET)
    public String feedback(Model model) {
        model.addAttribute("contactUsForm", new ContactUs());
        return "feedback";
    }

    @RequestMapping(value = "/subscribe-to-newsletter", method = RequestMethod.GET)
    public String newsletter(Model model) {
        return "newsletter";
    }
    
    @RequestMapping(value = "/whistle-blowing")
    public String whistleBlowing(){
        return "whistleblowing";
    }

}
