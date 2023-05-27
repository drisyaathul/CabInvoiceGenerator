package com.cabInvoice;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CabInvoiceGeneratorTest {
    /*
     * creating object of CabInvoiceGenerator.
     */
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
//UC1:
    @Test
    public void givenDistanceShouldReturnFare(){
        double distance = 2.0;
        int time = 5;
        double result = cabInvoiceGenerator.calculateFare(distance,time);
        Assertions.assertEquals(25,result);
    }
//UC2:
    @Test
    public void givenMultipleRidesShouldReturnAggregateFare(){
        /*
         * Calculate Aggregate Total for all
         */
        Ride ride1 = new Ride(15,10);
        Ride ride2 = new Ride(5,3);
        Ride ride3 = new Ride(0.5,1);
        Ride[] rides = {ride1,ride2,ride3};
        double aggregateFare = cabInvoiceGenerator.calculateAggregateFare(rides);
        Assertions.assertEquals(219,aggregateFare);
    }
    // UC_3
    @Test
    public void testInvoiceGenerator() {
        // Create an instance of CabInvoiceGenerator
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();

        // Create an array of rides
        Ride[] rides = {
                new Ride(5, 15),
                new Ride(3, 10),
                new Ride(8, 25)
        };

        // Generate the invoice for the array of rides
        Invoice invoice = cabInvoiceGenerator.invoiceGenerator(rides);

        // Assert the invoice details
        Assertions.assertEquals(3, invoice.getTotalNumberRides());
        Assertions.assertEquals(210.0, invoice.getTotalFare());
        Assertions.assertEquals(70, invoice.getAverageFarePerRide());
    }
    @Test
    public void givenUserShouldReturnInvoice(){
        /*
         * Given user id should return Invoice
         */
        InvoiceService invoiceService = new InvoiceService();
        // Create an array of rides
        Ride[] rides1 = {
                new Ride(5, 3),
                new Ride(10, 8),
                new Ride(6, 4)
        };

        invoiceService.addRides("user101",rides1);
        Invoice invoice = invoiceService.getInvoiceByUserId("user101");

        Assertions.assertEquals(3,invoice.getTotalNumberOfRides());
        Assertions.assertEquals(225,invoice.getTotalFare());
        Assertions.assertEquals(75,invoice.getAverageFarePerRide());
    }
}

