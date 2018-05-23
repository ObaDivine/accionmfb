/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accionmfb.website.repository;

import com.accionmfb.website.model.AgentBanking;
import com.accionmfb.website.model.Agents;
import java.util.List;

/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
public interface IFISAgentsRepositoryCustom {
    public List<Agents> getAgentsByCity(String state, String city);
    public List<Agents> getAgentsByState(String state);
    public boolean checkIfAgentExist(AgentBanking agentDetails);
    public String createAgent(AgentBanking agentDetails);
}
