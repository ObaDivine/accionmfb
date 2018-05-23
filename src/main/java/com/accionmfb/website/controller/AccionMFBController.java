/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accionmfb.website.controller;

import com.accionmfb.website.model.States;
import com.accionmfb.website.service.AccionMFBServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
@RestController
@RequestMapping(value = "/accionMFB")
public class AccionMFBController {

    @Autowired
    private final AccionMFBServices accionMFBServices;

    public AccionMFBController(AccionMFBServices accionMFBServices) {
        this.accionMFBServices = accionMFBServices;
    }

    @RequestMapping(value = "/nigeria/states", method = RequestMethod.GET)
    public List<States> getStatesInNigeria() {
        return accionMFBServices.getStates();
    }

    @RequestMapping(value = "/nigeria/lgas", method = RequestMethod.GET)
    public List<States> getLGAsInNigeria() {
        return accionMFBServices.getLGAs();
    }

    @RequestMapping(value = "/nigeria/states/{state}", method = RequestMethod.GET)
    public List<States> getStateLGAs(@PathVariable String state) {
        return accionMFBServices.getStateLGAs(state);
    }
}
