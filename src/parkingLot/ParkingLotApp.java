package parkingLot;

import parkingLot.Stratergies.ParkingSpotAssingmentStratergy;
import parkingLot.controllers.TicketController;
import parkingLot.dtos.TicketDtos.IssueTicketRequestDto;
import parkingLot.dtos.TicketDtos.IssueTicketResponseDto;
import parkingLot.factories.ParkingSpotAssingmentFactory;
import parkingLot.models.ParkingSpotStratergyType;
import parkingLot.models.Ticket;
import parkingLot.repositories.GateRepository;
import parkingLot.repositories.VehicleRepository;
import parkingLot.services.TicketService;

public class ParkingLotApp {
    public static void main(String[] args) {
        IssueTicketRequestDto issueTicketRequestDto = new IssueTicketRequestDto();
        issueTicketRequestDto.setGateId(111L);
        issueTicketRequestDto.setOperatorId(222L);
        issueTicketRequestDto.setOwnerName("Brian Sam");
        issueTicketRequestDto.setVehicleNumber("CG07BR0026");
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        TicketService ticketService = new TicketService(gateRepository,
                vehicleRepository, ParkingSpotAssingmentFactory.getInstance(ParkingSpotStratergyType.NEAREST));

        TicketController ticketController = new TicketController(ticketService);
        IssueTicketResponseDto responseDto = ticketController.issueTicket(issueTicketRequestDto);
        System.out.println(responseDto);

    }
}
