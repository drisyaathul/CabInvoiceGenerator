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
}
