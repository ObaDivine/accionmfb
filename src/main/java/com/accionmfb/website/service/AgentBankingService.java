/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accionmfb.website.service;

import com.accionmfb.website.model.AgentBanking;
import com.accionmfb.website.model.Agents;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
@Service
public interface AgentBankingService {

    public List<Agents> getAllAgents();
    public List<Agents> getAgentsByState(String state);
    public List<Agents> getAgentsByCity(String state, String city);
    public String createAgent(AgentBanking agentDetails);
}
