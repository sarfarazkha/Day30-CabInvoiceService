package com.bridgelab.cab;

import com.bridgelabz.cab.InvoiceGenerator;
import com.bridgelabz.cab.InvoiceSummary;
import com.bridgelabz.cab.Ride;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class InvoiceServiceTest {

    InvoiceGenerator invoiceGenerator = null;
    @Before
    public void setUp() throws Exception {
        invoiceGenerator = new InvoiceGenerator();
    }


    @Test

    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 1.0;
        int time = 10;
        double fare = invoiceGenerator.calculateFare(distance, time);
        assertEquals(20, fare, 0.0);
    }


    @Test

    public void givenDistanceAndTime_WhenTotalFareLessThan10_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        assertEquals(5, fare, 0.0);
    }


    @Test
    public void givenMultipleRidesShouldReturnRideSummary() {
        Ride[] rides = {new Ride(2.0, 5), new Ride(0.1, 1)};
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
        assertEquals(expectedSummary, summary);
    }


    @Test
    public void givenUserIdShouldReturnTheInvoice() {
        String userId = "abc@123";
        Ride[] rides = {new Ride(2.0, 5), new Ride(0.1, 1)};
        invoiceGenerator.addRides(userId, rides);
        InvoiceSummary summary =  invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary checkSummary = new InvoiceSummary(2, 30.0);
        assertEquals(summary, checkSummary);
    }
}
