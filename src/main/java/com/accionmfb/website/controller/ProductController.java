/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accionmfb.website.controller;

import com.accionmfb.website.model.AgentBanking;
import com.accionmfb.website.model.BrightaAccount;
import com.accionmfb.website.model.BrightaLoan;
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

/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private AccionMFBServices accionMFBServices;

    @Autowired
    MessageSource messageSource;

    //individual products and services
    @RequestMapping(value = "/brighta-accounts", method = RequestMethod.GET)
    public String brightaAccounts() {
        return "brightaaccounts";
    }

    @RequestMapping(value = "/brighta-purse", method = RequestMethod.GET)
    public String brightaPurse() {
        return "brightapurse";
    }

    @RequestMapping(value = "/brighta-future", method = RequestMethod.GET)
    public String brightaFuture() {
        return "brightafuture";
    }

    @RequestMapping(value = "/brighta-investor", method = RequestMethod.GET)
    public String brightaInvestor() {
        return "brightainvestor";
    }

    @RequestMapping(value = "/brighta-together", method = RequestMethod.GET)
    public String brightaTogether() {
        return "brightatogether";
    }

    @RequestMapping(value = "/brighta-xtra", method = RequestMethod.GET)
    public String brightaXtra() {
        return "brightaxtra";
    }

    @RequestMapping(value = "/brighta-socio-investor", method = RequestMethod.GET)
    public String brightaSocioInvestor() {
        return "brightasocioinvestor";
    }

    @RequestMapping(value = "/brighta-plus", method = RequestMethod.GET)
    public String brightaPlus() {
        return "brightaplus";
    }

    @RequestMapping(value = "/save-brighta", method = RequestMethod.GET)
    public String brightaSave() {
        return "brightasave";
    }

    @RequestMapping(value = "/brighta-loans", method = RequestMethod.GET)
    public String brightaLoans() {
        return "brightaloanshome";
    }

    @RequestMapping(value = "/brighta-myown-loan", method = RequestMethod.GET)
    public String brightaMyOwnLoan() {
        return "brightamyownloan";
    }

    @RequestMapping(value = "/brighta-myown-loan-plus", method = RequestMethod.GET)
    public String brightaMyOwnLoanPlus() {
        return "brightamyownloanplus";
    }

    @RequestMapping(value = "/brighta-myown-asset-loan", method = RequestMethod.GET)
    public String brightaMyOwnAssetLoan() {
        return "brightamyownassetloan";
    }

    @RequestMapping(value = "/brighta-myagent", method = RequestMethod.GET)
    public String brightaMyAgentLoan() {
        return "brightamyagentloan";
    }

    @RequestMapping(value = "/brighta-myown-home-loan", method = RequestMethod.GET)
    public String brightaMyOwnHomeLoan() {
        return "brightamyownhomeloan";
    }

    @RequestMapping(value = "/brighta-myloan", method = RequestMethod.GET)
    public String brightaMyLoan() {
        return "brightamyloan";
    }

    @RequestMapping(value = "/brighta-plwd", method = RequestMethod.GET)
    public String peopleLivingWithDisability() {
        return "brightaplwd";
    }

    //SME products and services
    @RequestMapping(value = "/brighta-sme-education", method = RequestMethod.GET)
    public String brightaSMEEducation() {
        return "brightasmeeducation";
    }

    @RequestMapping(value = "/brighta-sme-capital", method = RequestMethod.GET)
    public String brightaSMECapital() {
        return "brightasmecapital";
    }

    @RequestMapping(value = "/brighta-sme-solar", method = RequestMethod.GET)
    public String brightaSMESolar() {
        return "brightasmesolar";
    }

    @RequestMapping(value = "/brighta-ourown-loan", method = RequestMethod.GET)
    public String brightaOurOwnLoan() {
        return "brightaourownloan";
    }

    //Corporate product and service
    @RequestMapping(value = "/brighta-paygo", method = RequestMethod.GET)
    public String brightaPayGoLoan() {
        return "brightapaygoloan";
    }

    @RequestMapping(value = "/brighta-school-plus", method = RequestMethod.GET)
    public String brightaMySchoolPlusLoan() {
        return "brightaschoolplus";
    }

    @RequestMapping(value = "/brighta-school-xtra", method = RequestMethod.GET)
    public String brightaMySchoolXtraLoan() {
        return "brightaschoolxtra";
    }

    @RequestMapping(value = "/open-brighta-account", method = RequestMethod.GET)
    public String brightaAccountOpening(Model model) {
        model.addAttribute("brightaAccount", new BrightaAccount());
        model.addAttribute("genders", accionMFBServices.genders());
        //Retrieve all the states from DB by calling the end point
        model.addAttribute("states", accionMFBServices.getStates());
        return "accountopening";
    }

    @RequestMapping(value = "/create-brighta-account", method = RequestMethod.POST)
    public String createBrightaAccount(@Valid BrightaAccount account, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("genders", accionMFBServices.genders());
            //Retrieve all the states from DB by calling the end point
            model.addAttribute("states", accionMFBServices.getStates());
            return "accountopening";
        }
        String message = accionMFBServices.createBrightaAccount(account);

        //This section indicates that the transaction was successful
        if (message != null) {
            //Create a fresh model form without values
            model.addAttribute("agentBanking", new AgentBanking());
            model.addAttribute("genders", accionMFBServices.genders());
            //Retrieve all the states from DB by calling the end point
            model.addAttribute("states", accionMFBServices.getStates());
            //Add message to model
            model.addAttribute("message", messageSource.getMessage("applicationMessages.success", new Object[0], Locale.ENGLISH));

            return "waccountopening";
        }

        //This point means the transacion was not successful
        model.addAttribute("genders", accionMFBServices.genders());
        //Retrieve all the states from DB by calling the end point
        model.addAttribute("states", accionMFBServices.getStates());
        //Add message to model
        model.addAttribute("message", messageSource.getMessage("applicationMessages.failed", new Object[0], Locale.ENGLISH));

        return "accountopening";
    }

    @RequestMapping(value = "/brighta-loan-request", method = RequestMethod.GET)
    public String brightaLoanRequest(Model model) {
        model.addAttribute("brightaLoan", new BrightaLoan());
        return "loanrequest";
    }

    @RequestMapping(value = "/request-brighta-loan", method = RequestMethod.POST)
    public String requestBrightaLoan(@Valid BrightaLoan loan, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "loanrequest";
        }
        return "loanrequest";
    }

}
