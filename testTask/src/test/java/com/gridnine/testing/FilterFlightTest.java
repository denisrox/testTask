package com.gridnine.testing;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FilterFlightTest {

    @Test
    public void getCurrentFlights() {
        List<Flight> flightList = FlightBuilder.createFlights();
        List<Flight> actualFligh = new ArrayList<>(flightList);

        actualFligh.remove(2);
        flightList=FilterFlight.getCurrentFlights(flightList);
        Assert.assertEquals(flightList, actualFligh);
    }

    @Test
    public void getCorrectFlights() {
        List<Flight> flightList = FlightBuilder.createFlights();
        List<Flight> actualFligh = new ArrayList<>(flightList);

        actualFligh.remove(3);
        flightList=FilterFlight.getCorrectFlights(flightList);
        Assert.assertEquals(flightList, actualFligh);
    }

    @Test
    public void getFlightsWithShortTransfer() {
        List<Flight> flightList = FlightBuilder.createFlights();
        List<Flight> actualFligh = new ArrayList<>(flightList);

        actualFligh.remove(4);
        actualFligh.remove(4);
        flightList=FilterFlight.getFlightsWithShortTransfer(flightList);
        Assert.assertEquals(flightList, actualFligh);
    }


}