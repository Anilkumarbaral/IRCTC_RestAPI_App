package ins.ashokit.Service;

import org.springframework.stereotype.Service;

import ins.ashokit.Passenger;
import ins.ashokit.Ticket;
@Service

public interface BookingService {
	public Ticket bookTicket(Passenger passengerDtls);
	
	public Ticket getTicket(Integer ticketNumber);
	

}
