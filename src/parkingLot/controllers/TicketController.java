package parkingLot.controllers;

import parkingLot.dtos.TicketDtos.IssueTicketRequestDto;
import parkingLot.dtos.TicketDtos.IssueTicketResponseDto;
import parkingLot.models.ResponseStatus;
import parkingLot.models.Ticket;
import parkingLot.services.TicketService;

public class TicketController {
    IssueTicketRequestDto issueTicketRequestDto;
    IssueTicketResponseDto issueTicketResponseDto;
    TicketService ticketService;

    public TicketController(  TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto issueTicketRequestDto) {

        IssueTicketResponseDto responseDto = new IssueTicketResponseDto();

        try {
            Ticket ticket = ticketService.issueTicket(issueTicketRequestDto.getVehicleNumber(),
                    issueTicketRequestDto.getEntryTime(),
                    issueTicketRequestDto.getOwnerName(),
                    issueTicketRequestDto.getGateId(),
                    issueTicketRequestDto.getOperatorId());

            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            responseDto.setFloor(ticket.getParkingSpot().getParkingFloor().getFloorNumber());
            responseDto.setParkingSpotNumber(ticket.getParkingSpot().getSpotNumber());
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            throw new RuntimeException(e);
        }

        return responseDto;



    };
}
