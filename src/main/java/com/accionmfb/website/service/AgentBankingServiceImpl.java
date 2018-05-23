/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accionmfb.website.service;

import com.accionmfb.website.model.AgentBanking;
import com.accionmfb.website.model.Agents;
import com.accionmfb.website.repository.IFISAgentsRepository;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
@Service
public class AgentBankingServiceImpl implements AgentBankingService{

    @Autowired
    private IFISAgentsRepository ifisAgentsRepository;
    
    @Autowired
    MessageSource messageSource;
    
    @Override
    public List<Agents> getAllAgents() {
        return ifisAgentsRepository.findAll();
    }

    @Override
    public List<Agents> getAgentsByState(String state) {
        return ifisAgentsRepository.getAgentsByState(state);
    }

    @Override
    public List<Agents> getAgentsByCity(String state, String city) {
        return ifisAgentsRepository.getAgentsByCity(state,city);
    }
    
    @Override
    public String createAgent(AgentBanking agentDetails){
       boolean agentExist = ifisAgentsRepository.checkIfAgentExist(agentDetails);
       if(agentExist != false){
           return messageSource.getMessage("applicationMessages.agentExist", new Object[0], Locale.ENGLISH);
       }
       
       //persist the agent details
       String message = ifisAgentsRepository.createAgent(agentDetails);
       if(message == "succeed"){
           return messageSource.getMessage("applicationMessages.success", new Object[0], Locale.ENGLISH);
       }
       else{
           return messageSource.getMessage("applicationMessages.failed", new Object[0], Locale.ENGLISH);
       }
    }
    
}
