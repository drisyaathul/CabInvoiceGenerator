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
    //UC4:
    @Test
    public void givenUserShouldReturnInvoice(){

        RideRepositoryImpl rideRepository = new RideRepositoryImpl();
        InvoiceService invoiceService = new InvoiceService(rideRepository);

        Ride ride1 = new Ride(15,10);
        Ride ride2 = new Ride(5,3);
        Ride ride3 = new Ride(0.5,1);
        Ride ride4 = new Ride(6,10);
        Ride[] rides1 = {ride1,ride2};
        Ride[] rides2 = {ride3,ride4};
        rideRepository.addRides("user1",rides1);
        rideRepository.addRides("user2",rides2);
        Invoice actualInvoice1 = invoiceService.getInvoiceByUserId("User1");
        Invoice actualInvoice2 = invoiceService.getInvoiceByUserId("User2");
        Invoice expectedInvoice1 = new Invoice(2,168,75);
        Invoice expectedInvoice2 = new Invoice(2,76,50);
        Assertions.assertEquals(expectedInvoice1,actualInvoice1);
        Assertions.assertEquals(expectedInvoice2,actualInvoice2);
    }
}

