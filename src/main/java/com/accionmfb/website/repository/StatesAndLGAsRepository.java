/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accionmfb.website.repository;

import com.accionmfb.website.model.States;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
@Repository
public interface StatesAndLGAsRepository extends JpaRepository<States, Long>, StatesAndLGAsRepositoryCustom{

}
