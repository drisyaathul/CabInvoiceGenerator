package com.cabInvoice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepositoryImpl implements RideRepository {
    private Map<String, List<Ride>> userRides;

    public RideRepositoryImpl() {
        this.userRides = new HashMap<>();
    }

    @Override
    public List<Ride> getRidesByUserId(String userId) {
        return userRides.getOrDefault(userId, new ArrayList<>());
    }

    public void addRides(String userId, Ride[] rides) {
        userRides.put(userId, List.of(rides));
    }

}
