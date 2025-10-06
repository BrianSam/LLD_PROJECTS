package parkingLot.factories;

import parkingLot.Stratergies.NearestSpotAssingmentStratergy;
import parkingLot.Stratergies.ParkingSpotAssingmentStratergy;
import parkingLot.models.ParkingSpotStratergyType;

public class ParkingSpotAssingmentFactory {
    public static ParkingSpotAssingmentStratergy getInstance(ParkingSpotStratergyType parkingSpotStratergyType) {
        if(parkingSpotStratergyType.equals(ParkingSpotStratergyType.NEAREST)){
            return new NearestSpotAssingmentStratergy();
        }
        return null;
    }
}
