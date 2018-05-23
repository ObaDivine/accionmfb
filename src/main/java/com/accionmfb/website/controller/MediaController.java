/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accionmfb.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Brian A. Okon <brian.okon@entitytechnology.com>
 */
@Controller
@RequestMapping("/media")
public class MediaController {
    //Accion media section
    @RequestMapping(value = "/news-and-events", method = RequestMethod.GET)
    public String accionMedia() {
        return "accionmedia";
    }

    @RequestMapping(value = "/press-release", method = RequestMethod.GET)
    public String pressRelease() {
        return "pressrelease";
    }

    @RequestMapping(value = "/milestone", method = RequestMethod.GET)
    public String milestone() {
        return "milestone";
    }
    
    @RequestMapping(value = "/corporate-responsibility", method = RequestMethod.GET)
    public String corporateResponsibility() {
        return "corporateresponsibility";
    }
    
    @RequestMapping(value = "/accion-events")
    public String accionEvents(){
        return "accionevents";
    }

}
