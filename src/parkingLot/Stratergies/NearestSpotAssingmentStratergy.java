package parkingLot.Stratergies;

import parkingLot.factories.ParkingSpotAssingmentFactory;
import parkingLot.models.ParkingLot;
import parkingLot.models.ParkingSpot;
import parkingLot.models.Vehicle;

public class NearestSpotAssingmentStratergy implements ParkingSpotAssingmentStratergy{
    @Override
    public ParkingSpot getParkingSpot(ParkingLot parkingLot, Vehicle vehicle) {
        return new ParkingSpot();
    }
}
