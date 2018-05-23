package com.accionmfb.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class WebsiteApplication extends SpringBootServletInitializer{

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebsiteApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WebsiteApplication.class, args);
    }
    
    @RequestMapping("/accion")
    public String home(){return "index";}
}
