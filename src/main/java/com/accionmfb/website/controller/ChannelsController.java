/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accionmfb.website.controller;

import com.accionmfb.website.model.AgentBanking;
import com.accionmfb.website.model.States;
import com.accionmfb.website.service.AccionMFBServices;
import com.accionmfb.website.service.AgentBankingService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Locale;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author bokon
 */
@Controller
@RequestMapping(value = "/channels")
public class ChannelsController {

    @Autowired
    private final AgentBankingService agentBankingService;

    @Autowired
    private final AccionMFBServices accionMFBServices;

    @Autowired
    MessageSource messageSource;

    public ChannelsController(AgentBankingService agentBankingService, AccionMFBServices accionMFBServices) {
        this.agentBankingService = agentBankingService;
        this.accionMFBServices = accionMFBServices;
    }

    @RequestMapping(value = "/agent-banking", method = RequestMethod.GET)
    public String agent(Model model) {
        model.addAttribute("agentBanking", new AgentBanking());
        model.addAttribute("genders", accionMFBServices.genders());
        model.addAttribute("businessTypes", accionMFBServices.businessTypes());
        //Retrieve all the states from DB by calling the end point
        model.addAttribute("statesAndLGAs", new States());
        model.addAttribute("states", accionMFBServices.getStates());
        model.addAttribute("lgas", "");
        return "agenthome";
    }

    @RequestMapping(value = "/agent-banking/get-filtered-agents", method = RequestMethod.POST)
    public String getAgentsByStateAndLGA(States state, Model model) {
        if (!state.getState().equals("") && !state.getLga().equals("")) {
            model.addAttribute("statesAndLGAs", new States());
            model.addAttribute("states", accionMFBServices.getStates());
            model.addAttribute("lgas", "");
            model.addAttribute("retrievedAgents", agentBankingService.getAgentsByCity(state.getState(), state.getLga()));
        }

        if (state.getState().equals("") && !state.getLga().equals("")) {
            model.addAttribute("statesAndLGAs", new States());
            model.addAttribute("states", accionMFBServices.getStates());
            model.addAttribute("lgas", "");
            model.addAttribute("retrievedAgents", agentBankingService.getAgentsByCity(state.getState(), state.getLga()));
        }

        if (!state.getState().equals("") && state.getLga().equals("")) {
            model.addAttribute("statesAndLGAs", new States());
            model.addAttribute("states", accionMFBServices.getStates());
            model.addAttribute("lgas", "");
            model.addAttribute("retrievedAgents", agentBankingService.getAgentsByState(state.getState()));
        }
        model.addAttribute("statesAndLGAs", new States());
        model.addAttribute("states", accionMFBServices.getStates());
        model.addAttribute("lgas", "");
        return "requestedagents";
    }

    @RequestMapping(value = "/agent-banking/create-agent", method = RequestMethod.POST)
    public String createAgent(@Valid AgentBanking agentBanking, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("genders", accionMFBServices.genders());
            model.addAttribute("businessTypes", accionMFBServices.businessTypes());
            //Retrieve all the states from DB by calling the end point
            model.addAttribute("states", accionMFBServices.getStates());
            model.addAttribute("lgas", accionMFBServices.getLGAs());
            return "agenthome";
        }

        String message = agentBankingService.createAgent(agentBanking);
        //Check the message to determine if successful or not
        if (message.equals(messageSource.getMessage("applicationMessages.success", new Object[0], Locale.ENGLISH))) {
            //Create a fresh model form without values
            model.addAttribute("agentBanking", new AgentBanking());
            model.addAttribute("genders", accionMFBServices.genders());
            model.addAttribute("businessTypes", accionMFBServices.businessTypes());
            //Retrieve all the states from DB by calling the end point
            model.addAttribute("states", accionMFBServices.getStates());
            model.addAttribute("lgas", accionMFBServices.getLGAs());
            //Add message to model
            model.addAttribute("message", message);

            return "agenthome";
        }
        //This section means the operation was not successful.
        model.addAttribute("genders", accionMFBServices.genders());
        model.addAttribute("businessTypes", accionMFBServices.businessTypes());
        //Retrieve all the states from DB by calling the end point
        model.addAttribute("states", accionMFBServices.getStates());
        model.addAttribute("lgas", accionMFBServices.getLGAs());
        //Add message to model
        model.addAttribute("message", message);
        return "agenthome";
    }

    @RequestMapping(value = "/agent-banking/get-agents/{state}", method = RequestMethod.GET)
    public String getAgentsByState(@PathVariable String state, Model model) {
        model.addAttribute("retrievedAgents", agentBankingService.getAgentsByState(state));
        model.addAttribute("states", accionMFBServices.getStates());
        return "requestedagents";
    }

    @RequestMapping(value = "/agent-banking/get-agents/auto")
    public String getAgentsAutomatically(Model model) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //Create a Json Tree from the IP API returned Json
        JsonNode rootNode = objectMapper.readTree(getEmployees());
        JsonNode cityNode = rootNode.path("city");
        model.addAttribute("statesAndLGAs", new States());
        model.addAttribute("states", accionMFBServices.getStates());
        model.addAttribute("lgas", "");
        model.addAttribute("retrievedAgents", agentBankingService.getAgentsByCity("", cityNode.asText()));
        return "requestedagents";
    }

    private String getEmployees() {
        final String uri = "http://ip-api.com/json";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

    @RequestMapping(value = "/accion-ussd", method = RequestMethod.GET)
    public String accionUSSD() {
        return "ussd";
    }

    @RequestMapping(value = "/mobile-banking", method = RequestMethod.GET)
    public String mobileBanking() {
        return "mobilebanking";
    }

    @RequestMapping(value = "/internet-banking")
    public ModelAndView internetBanking() {
        return new ModelAndView("redirect:" + "http://localhost:8182/internet-banking/home");
    }
}
