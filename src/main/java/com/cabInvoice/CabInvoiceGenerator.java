package com.cabInvoice;

public class CabInvoiceGenerator {

    public static final double costPerKilometer = 10.0;
    public static final double costPerMinute = 1.0;
    public static final double minimumFare = 5;
    public static final double costPerKilometer_Premium = 15.0;
    public static final double costPerMinute_Premium = 2.0;
    public static final double minimumFare_Premium = 20;

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
    //UC2:
    public double calculateAggregateFare(Ride[] rides){

        double aggregateFare = 0;
        for (Ride ride : rides) {
            aggregateFare += calculateFare(ride.getDistance(),ride.getTime());
        }
        return aggregateFare;
    }
    //UC3:
    public Invoice invoiceGenerator(Ride[] rides){
        /*
         * Return Total Number of Rides
         * Return the Total Fare
         * Return Average Fare per Ride
         */
        int totalNumberOfRides = rides.length;
        double totalFare = calculateAggregateFare(rides);
        double averageFarePerRide = (totalFare/totalNumberOfRides);

        return new Invoice(totalNumberOfRides,totalFare,averageFarePerRide);
    }
    //UC5:
    public double calculateFarePremium(double distance, int time) {
        /*
         * Calculating Total Fare.
         * If total fare is less than 20,then return minimum fare_Premium. otherwise return total fare itself.
         */
        double totalFare = (distance * costPerKilometer_Premium) + (time * costPerMinute_Premium);
        if (totalFare < 20) {
            return minimumFare_Premium;
        }
        return totalFare;
    }
    public double calculateAggregateFarePremium(Ride[] rides){

        double aggregateFare = 0;
        for (Ride ride : rides) {
            aggregateFare += calculateFarePremium(ride.getDistance(),ride.getTime());
        }
        return aggregateFare;
    }
}
