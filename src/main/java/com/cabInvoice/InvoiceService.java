package com.cabInvoice;

import java.util.List;

public class InvoiceService {
    private RideRepository rideRepository;

    public InvoiceService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public Invoice getInvoiceByUserId(String userId) {
        // Retrieve the list of rides from the ride repository based on the user ID
        List<Ride> rides = rideRepository.getRidesByUserId(userId);

        // Create an instance of the CabInvoiceGenerator
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();

        // Generate the invoice using the rides
        Invoice invoice = cabInvoiceGenerator.invoiceGenerator(rides.toArray(new Ride[rides.size()]));

        // Return the generated invoice
        return invoice;
    }
}

