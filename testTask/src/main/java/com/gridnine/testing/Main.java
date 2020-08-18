package com.gridnine.testing;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Filter;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Flight> flightList = FlightBuilder.createFlights();
        System.out.println(flightList);
        System.out.println(FilterFlight.getCorrectFlights(flightList));
        System.out.println(FilterFlight.getFlightsWithShortTransfer(flightList));
        System.out.println(flightList);

    }
}
