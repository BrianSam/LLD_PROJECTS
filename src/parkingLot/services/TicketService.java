package parkingLot.services;

import parkingLot.Stratergies.NearestSpotAssingmentStratergy;
import parkingLot.Stratergies.ParkingSpotAssingmentStratergy;
import parkingLot.exceptions.GateNotFoundException;
import parkingLot.models.Gate;
import parkingLot.models.ParkingLot;
import parkingLot.models.Ticket;
import parkingLot.models.Vehicle;
import parkingLot.repositories.GateRepository;
import parkingLot.repositories.VehicleRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {
   private GateRepository gateRepository;
   private VehicleRepository vehicleRepository;
   private ParkingSpotAssingmentStratergy parkingSpotAssingmentStratergy;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingSpotAssingmentStratergy parkingSpotAssingmentStratergy) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingSpotAssingmentStratergy = parkingSpotAssingmentStratergy;

    }

    public Ticket issueTicket(String vehicleNumber,
                              Date entryTime,
                              String ownerName,
                              Long gateId,
                              Long operatorId
                              ) throws GateNotFoundException {

        Ticket ticket = new Ticket();
        Optional<Gate> optionalGate = gateRepository.getGateById(gateId);
        if (!optionalGate.isEmpty()) {
            throw new GateNotFoundException("Invalid gate id passed !!");
        };
        Gate gate = optionalGate.get();
        ticket.setGate(gate);
        ticket.setEntryTime(new Date());
        ticket.setOperator(gate.getOperator());
        Optional<Vehicle>  optionalVehicle = vehicleRepository.getVehicleByNumber(vehicleNumber);
        Vehicle vehicle = null;
        if (optionalVehicle.isEmpty()) {
                Vehicle v = new Vehicle();
                v.setNumber(vehicleNumber);
                v.setOwnerName(ownerName);
                 vehicle = vehicleRepository.addVehicle(v);
        }
        else {
            vehicle = optionalVehicle.get();
        }
        ticket.setVehicle(vehicle);
        ticket.setParkingSpot(parkingSpotAssingmentStratergy.getParkingSpot(gate.getParkingLot(), vehicle));
        return ticket;




    }
}
