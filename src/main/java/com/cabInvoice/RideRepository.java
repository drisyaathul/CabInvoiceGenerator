package com.cabInvoice;

import java.util.List;

public interface RideRepository {
    List<Ride> getRidesByUserId(String userId);
}
}
