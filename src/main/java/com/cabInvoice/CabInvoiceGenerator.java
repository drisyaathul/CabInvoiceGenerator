package com.cabInvoice;

public class CabInvoiceGenerator {
    /*
     * UC1:
     * Given Cost per kilometer, Cost per Minute and Minimum Fare.
     */
    public static final double costPerKilometer = 10.0;
    public static final double costPerMinute = 1.0;
    public static final double minimumFare = 5;

    public double calculateFare(double distance, int time) {
        /*
         * Calculating Total Fare.
         * If total fare is less than 5,then return minimum fare. otherwise return total fare itself.
         */
        double totalFare = (distance * costPerKilometer) + (time * costPerMinute);
        if (totalFare < 5) {
            return minimumFare;
        }
        return totalFare;
    }
}
