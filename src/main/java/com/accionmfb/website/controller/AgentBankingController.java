/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accionmfb.website.controller;

import com.accionmfb.website.model.Agents;
import com.accionmfb.website.model.States;
import com.accionmfb.website.service.AccionMFBServices;
import com.accionmfb.website.service.AgentBankingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
@RestController
@RequestMapping(value = "/agent-banking")
public class AgentBankingController {
    
    @Autowired
    private final AgentBankingService agentBankingService;
    
    @Autowired
    private final AccionMFBServices accionMFBServices;
   
    public AgentBankingController(AgentBankingService agentBankingService, AccionMFBServices accionMFBServices){
        this.agentBankingService = agentBankingService;
        this.accionMFBServices = accionMFBServices;
    }
    
    
    @RequestMapping(value = "/agents/", method = RequestMethod.GET)
    public List<Agents> getAnAgent(){
        return agentBankingService.getAllAgents();
    }
    
    @RequestMapping(value = "/agents/{state}", method = RequestMethod.GET)
    public List<Agents> getAgentsByState(@PathVariable String state){
        //Check if the state parameter is not null. This means the parameter is provided
        if(state != null){
            return agentBankingService.getAgentsByState(state);
        }
        
        //This point means the state parameter is not provided. Hence deduce from the request location using Geolocation 
        return agentBankingService.getAgentsByState(state);
    }
    
    @RequestMapping(value = "/agents/{state}/{city}", method = RequestMethod.GET)
    public List<Agents> getAgentsByCity(@PathVariable String state, @PathVariable String city){
        return agentBankingService.getAgentsByCity(state, city);
    }
    
    @RequestMapping(value = "/get-state-lgas", method = RequestMethod.POST)
    public @ResponseBody List<States> getStateLGAs(String state, String lga){
        //Check for state and/ or lga parameter(s)
        return accionMFBServices.getStateLGAs(state);
    }
    
}
