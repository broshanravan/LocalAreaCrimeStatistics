package com.area.crime.statistic.LocalAreaCrimeStatistics.controllers;
import com.area.crime.statistic.LocalAreaCrimeStatistics.beans.CrimeDetails;
import com.area.crime.statistic.LocalAreaCrimeStatistics.beans.Locations;
import com.area.crime.statistic.LocalAreaCrimeStatistics.components.LocationRepository;
import com.area.crime.statistic.LocalAreaCrimeStatistics.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Configuration
@EnableAutoConfiguration
@RestController
public class CrimeDetailsController {


    @Autowired
    LocationRepository locationRepository;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value="https://data.police.uk/api/crimes-street/")
    public List<CrimeDetails> getCrimeDetailsForAll(HttpServletRequest request){

        String category = "all-crime";

        Locations location = locationRepository.getLocationForTheCrime(request);

        String latitude = String.valueOf(location.getLatitude());
        String longitude= String.valueOf(location.getLongitude());

        String searchAPI ="https://data.police.uk/api/crimes-street/"+ category +  longitude + latitude;

        RestTemplate restTemplate = restTemplate();
        List<CrimeDetails> CrimeDetails = restTemplate.getForObject(searchAPI ,List.class);

        if (CrimeDetails == null){
            throw new ResourceNotFoundException("Records for latitude " + latitude + "and longitude "+ longitude + " not found");
        }
        return CrimeDetails;


    }
    @GetMapping(value="https://data.police.uk/api/crimes-street/")
    public List<CrimeDetails> getCrimeDetailsForAntisocial(HttpServletRequest request){

        String category = "anti-social-behaviour";
        Locations location = locationRepository.getLocationForTheCrime(request);

        String latitude = String.valueOf(location.getLatitude());
        String longitude= String.valueOf(location.getLongitude());
        String searchAPI ="https://data.police.uk/api/crimes-street/"+ category +  longitude + latitude;


        RestTemplate restTemplate = restTemplate();
        List<CrimeDetails> CrimeDetails = restTemplate.getForObject(searchAPI ,List.class);

        if (CrimeDetails == null){
            throw new ResourceNotFoundException("Records for latitude " + latitude + "and longitude "+ longitude + " not found");
        }
        return CrimeDetails;


    }

    @GetMapping(value="https://data.police.uk/api/crimes-street/")
    public List<CrimeDetails> getCrimeDetailsForBurglary(HttpServletRequest request){

        String category = "burglary";
        Locations location = locationRepository.getLocationForTheCrime(request);

        String latitude = String.valueOf(location.getLatitude());
        String longitude= String.valueOf(location.getLongitude());
        String searchAPI ="https://data.police.uk/api/crimes-street/"+ category +  longitude + latitude;


        RestTemplate restTemplate = restTemplate();
        List<CrimeDetails> CrimeDetails = restTemplate.getForObject(searchAPI ,List.class);

        if (CrimeDetails == null){
            throw new ResourceNotFoundException("Records for latitude " + latitude + "and longitude "+ longitude + " not found");
        }
        return CrimeDetails;


    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}


