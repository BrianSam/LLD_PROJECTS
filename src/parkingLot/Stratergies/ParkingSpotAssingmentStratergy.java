package parkingLot.Stratergies;

import parkingLot.models.Gate;
import parkingLot.models.ParkingLot;
import parkingLot.models.ParkingSpot;
import parkingLot.models.Vehicle;

public interface ParkingSpotAssingmentStratergy {
    public ParkingSpot getParkingSpot(ParkingLot parkingLot, Vehicle vehicle);
}
