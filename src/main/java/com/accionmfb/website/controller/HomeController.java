/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accionmfb.website.controller;

import com.accionmfb.website.model.States;
import com.accionmfb.website.service.AccionMFBServices;
import com.accionmfb.website.service.AgentBankingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Brian Okon
 */
@Controller
//@EnableAutoConfiguration
//@RequestMapping("/kalis")
public class HomeController {
    
    @Autowired
    private final AccionMFBServices accionMFBServices;
    @Autowired
    MessageSource messageSource;

    public HomeController(AgentBankingService agentBankingService, AccionMFBServices accionMFBServices) {
        this.accionMFBServices = accionMFBServices;
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
        return "home";
    }

    @RequestMapping(value = "/about/about-accion", method = RequestMethod.GET)
    public String aboutus(Model model) {
        return "aboutaccion";
    }

    @RequestMapping(value = "/about/management-team", method = RequestMethod.GET)
    public String managementTeam(Model model) {
        return "management";
    }

    @RequestMapping(value = "/about/board-of-directors", method = RequestMethod.GET)
    public String boardOfDirectors(Model model) {
        return "board";
    }

    @RequestMapping(value = "/about/accion-financial", method = RequestMethod.GET)
    public String accionFinancial(Model model) {
        return "financial";
    }

    @RequestMapping(value = "/about/accion-partners", method = RequestMethod.GET)
    public String accionPartners(Model model) {
        return "partners";
    }

    @RequestMapping(value = "/about/privacy-policy", method = RequestMethod.GET)
    public String accionPrivacyPolicy(Model model) {
        return "privacy";
    }

    @RequestMapping(value = "/about/terms-of-use", method = RequestMethod.GET)
    public String accionTerms(Model model) {
        return "termsofuse";
    }

    public List<States> getStates() {
        return accionMFBServices.getStates();
    }
    
}
