package com.mycompany.myapp.service;

import org.springframework.stereotype.Component;

@Component
public class LocationService {

    public void confirmLocation(String localTuristicoPedido) {
        System.out.println("LocationService: ###########################################");
        System.out.println("LocationService: ###########################################");
        System.out.println("LocationService: ###########################################");
        System.out.println("LocationService:        CONFIRMING LOCATION " + localTuristicoPedido);
        System.out.println("LocationService:        LOCATION: " + localTuristicoPedido);
        System.out.println("LocationService: ###########################################");
        System.out.println("LocationService: ###########################################");
        System.out.println("LocationService: ###########################################\n\n\n");
    }
}
