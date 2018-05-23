/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accionmfb.website.repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
public class ContactUsRepositoryImpl implements ContactUsRepositoryCustom{
    @PersistenceUnit         
    private EntityManagerFactory emFactory;
        
}
