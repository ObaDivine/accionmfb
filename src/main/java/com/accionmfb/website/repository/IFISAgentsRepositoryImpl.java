/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accionmfb.website.repository;

import com.accionmfb.website.model.AgentBanking;
import com.accionmfb.website.model.Agents;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
public class IFISAgentsRepositoryImpl implements IFISAgentsRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Agents> getAgentsByCity(String state, String city) {
        TypedQuery<Agents> query = em.createQuery("SELECT a FROM Agents AS a WHERE a.agentState = :state AND a.city = :city", Agents.class)
                .setParameter("state", state)
                .setParameter("city", city);
        List<Agents> agentsInState = query.getResultList();
        return agentsInState;
    }

    @Override
    public List<Agents> getAgentsByState(String state) {
        TypedQuery<Agents> query = em.createQuery("SELECT a FROM Agents AS a WHERE a.agentState = '" + state + "'", Agents.class);
        List<Agents> agentsInState = query.getResultList();
        return agentsInState;
    }

    @Override
    public boolean checkIfAgentExist(AgentBanking agentDetails) {
        //EntityManager em = emf.createEntityManager();
        AgentBanking agentExist = (AgentBanking) em.createQuery("SELECT * FROM AgentBanking a WHERE a.phoneNumber = :phone OR a.email = :email OR a.businessName = :businessName")
                .setParameter("phone", agentDetails.getPhoneNumber())
                .setParameter("email", agentDetails.getEmail())
                .setParameter("bsuinessName", agentDetails.getBusinessName()).getSingleResult();

        //return true if there is an agent with matching details
        return (agentExist != null);
    }

    @Override
    @Transactional
    public String createAgent(AgentBanking agentDetails) {
        //EntityManager em = emf.createEntityManager();
        try {
            em.persist(agentDetails);
            return "succeed";
        } catch (Exception e) {
            return "failed";
        }
    }

}
