package com.area.crime.statistic.LocalAreaCrimeStatistics.beans;


import org.springframework.web.client.RestTemplate.*;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Locations implements Serializable {


    private String postcode;


    private double longitude;


    private double latitude;


    public Locations(String postcode, double longitude, double latitude) {
        this.postcode =postcode;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Locations(){

    }


    public double getLongitude() {
        return longitude;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

}
