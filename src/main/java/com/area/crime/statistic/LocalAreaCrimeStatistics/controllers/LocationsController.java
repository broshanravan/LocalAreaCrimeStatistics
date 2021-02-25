package com.area.crime.statistic.LocalAreaCrimeStatistics.controllers;



import com.area.crime.statistic.LocalAreaCrimeStatistics.beans.Locations;
import com.area.crime.statistic.LocalAreaCrimeStatistics.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Configuration
@EnableAutoConfiguration
@Component
public class LocationsController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private HttpServletRequest context;

    @GetMapping(value = "/location")
    public Locations getLocation() {
        return new Locations();
    }


    @GetMapping(value="/getLocation")
    public Locations getLocationForTheCrime(HttpServletRequest request){

        String postcode = request.getParameter("postcode");
        String searchAPI ="api.postcodes.io/postcodes/" +  postcode;

        Pattern pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher macher = pattern.matcher(postcode);
        boolean hasSpecialCharacher = macher.find();

        if(hasSpecialCharacher){
            throw new InvalidParameterException("postCode " + postcode + "is invalid");
        }
        //String requestURL = request.getRequestURL().substring(0, request.getRequestURL().indexOf(request.getRequestURI()));

        RestTemplate restTemplate = restTemplate();
        Locations location = restTemplate.getForObject(searchAPI ,Locations.class);

        if (location == null){
            throw new ResourceNotFoundException("Location with postCode " + postcode + "not found");
        }

        return location;

    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
