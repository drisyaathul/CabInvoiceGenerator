package com.cabInvoice;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CabInvoiceGeneratorTest {
    /*
     * creating object of CabInvoiceGenerator.
     */
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
    @Test
    public void givenDistanceShouldReturnFare(){
        double distance = 2.0;
        int time = 5;
        double result = cabInvoiceGenerator.calculateFare(distance,time);
        Assertions.assertEquals(25,result);
    }





}
