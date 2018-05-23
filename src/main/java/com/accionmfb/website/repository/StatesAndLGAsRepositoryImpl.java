/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accionmfb.website.repository;

import com.accionmfb.website.model.States;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
public class StatesAndLGAsRepositoryImpl implements StatesAndLGAsRepositoryCustom{
    @PersistenceContext         
    private EntityManager em;
    
    @Override
    public List<States> getStateLGAs(String state){
        List<States> stateLGA = em.createQuery("SELECT s.lga FROM States AS s WHERE s.state = :state")
                .setParameter("state", state)
                .getResultList();
        return stateLGA;
    }

    @Override
    public List<States> getStates() {
       List<States> states = em.createQuery("SELECT DISTINCT s.state FROM States AS s").getResultList();
        return states;
    }

    @Override
    public List<States> getLGAs() {
        List<States> lgas = em.createQuery("SELECT s.lga FROM States AS s").getResultList();
        return lgas;
    }
}
