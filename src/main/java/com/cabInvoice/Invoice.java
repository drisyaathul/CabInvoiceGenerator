package com.cabInvoice;

public class Invoice {

    private int totalNumberRides;
    private double totalFare;
    private double averageFarePerRide;

    public Invoice(int totalRides, double totalFare, double averageFarePerRide) {
        this.totalNumberRides = totalRides;
        this.totalFare = totalFare;
        this.averageFarePerRide = averageFarePerRide;
    }

    public int getTotalNumberRides() {
        return totalNumberRides;
    }

    public void setTotalNumberRides(int totalNumberRides) {
        this.totalNumberRides = totalNumberRides;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }

    public double getAverageFarePerRide() {
        return averageFarePerRide;
    }

    public void setAverageFarePerRide(double averageFarePerRide) {
        this.averageFarePerRide = averageFarePerRide;
    }

    @Override
    public String toString() {
        return "InvoiceGenerator{" +
                "totalRides=" + totalNumberRides +
                ", totalFare=" + totalFare +
                ", averageFarePerRide=" + averageFarePerRide +
                '}';
    }
}
