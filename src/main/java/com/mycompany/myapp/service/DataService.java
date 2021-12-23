package com.mycompany.myapp.service;

import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class DataService {

    public void confirmData(LocalDate dataPedido) {
        System.out.println("DataService: ###########################################");
        System.out.println("DataService: ###########################################");
        System.out.println("DataService: ###########################################");
        System.out.println("DataService:        CONFIRMING DATA " + dataPedido);
        System.out.println("DataService:        DATA " + dataPedido + " CONFIRMED");
        System.out.println("DataService: ###########################################");
        System.out.println("DataService: ###########################################");
        System.out.println("DataService: ###########################################\n\n\n");
    }
}
