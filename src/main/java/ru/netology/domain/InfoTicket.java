package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class InfoTicket implements Comparable<InfoTicket> {
    private int id;
    private int price;
    private String airportDeparture;
    private String airportArrival;
    private int travelTime;


    @Override
    public int compareTo(InfoTicket o) {
        return price - o.price;
    }

    public boolean matches(String from, String to) {
        return airportDeparture.equalsIgnoreCase(from) && airportArrival.equalsIgnoreCase(to);
    }
}
