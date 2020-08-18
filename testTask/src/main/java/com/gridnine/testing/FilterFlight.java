package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterFlight {
    static List<Flight> getCurrentFlights(List<Flight> flightList){
        return flightList.stream().filter((flight)->flight.getSegments().get(0).getDepartureDate().isAfter(LocalDateTime.now())).collect(Collectors.toList());
    };
    static List<Flight> getCorrectFlights(List<Flight> flightList){
        return flightList.stream().filter((flight)->flight.getSegments().get(0).getDepartureDate().isBefore(flight.getSegments().get(0).getArrivalDate())).collect(Collectors.toList());
    };
    static List<Flight> getFlightsWithShortTransfer(List<Flight> flightList){
        return flightList.stream().filter(flight -> {
            List<Segment> segments=flight.getSegments();
            int sum = 0;
            for(int i =0;i<segments.size()-1;i++)
            {
                sum+=Duration.between(segments.get(i).getArrivalDate(),segments.get(i+1).getDepartureDate()).toMinutes();
            }

            return sum<120?true:false;
        }).collect(Collectors.toList());
    };
}
