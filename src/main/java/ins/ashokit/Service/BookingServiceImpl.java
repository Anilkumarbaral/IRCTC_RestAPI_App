package ins.ashokit.Service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ins.ashokit.Passenger;
import ins.ashokit.Ticket;

@Service
public class BookingServiceImpl implements BookingService {

	private Map<Integer, Ticket> map = new HashMap<>();
	private int ticket = 1;

	@Override
	public Ticket bookTicket(Passenger passengerDtls) {
		Ticket t = new Ticket();
		BeanUtils.copyProperties(passengerDtls, t);
		t.setTicketCost("450");
		t.setStatus("Confirmed");
		t.setTicketNumber(ticket);
		map.put(ticket, t);
		ticket++;
		return t;
	}

	@Override
	public Ticket getTicket(Integer ticketNumber) {
		if (map.containsKey(ticketNumber)) {
			return map.get(ticketNumber);
		}
		return null;
	}

}
