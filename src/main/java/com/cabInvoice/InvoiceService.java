package com.cabInvoice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
*UC4 we create class InvoiceService
* to take User ID and Store Unique And Rides
 */
public class InvoiceService {
    private Map<String, List<Ride>> rideRepository;

    public InvoiceService() {
        rideRepository = new HashMap<>();
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.put(userId, List.of(rides));
    }

    public Invoice getInvoiceByUserId(String userId) {
        List<Ride> rides = rideRepository.get(userId);
        if (rides == null || rides.isEmpty()) {
            return null;
        }

        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        Invoice invoice = cabInvoiceGenerator.invoiceGenerator(rides.toArray(new Ride[rides.size()]));

        return invoice;
    }
    public Invoice generateInvoice(String userId, Ride[]rides,UserType userType){
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        if (userType.NORMAL.equals(userType)) {
            int totalNumberOfRides = rides.length;
            double totalFare = cabInvoiceGenerator.calculateAggregateFare(rides);
            double averageFarePerRide = (totalFare/totalNumberOfRides);

            return new Invoice(totalNumberOfRides,totalFare,averageFarePerRide,userId);
        }else if (userType.PREMIUM.equals(userType)) {
            int totalNumberOfRides = rides.length;
            double totalFare = cabInvoiceGenerator.calculateAggregateFarePremium(rides);
            double averageFarePerRide = (totalFare/totalNumberOfRides);

            return new Invoice(totalNumberOfRides,totalFare,averageFarePerRide,userId);
        }
        return null;
    }

}
