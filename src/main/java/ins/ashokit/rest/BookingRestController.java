package ins.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ins.ashokit.Passenger;
import ins.ashokit.Ticket;
import ins.ashokit.Service.BookingService;

@RestController
public class BookingRestController {
	
	@Autowired
	BookingService service;
	
	@PostMapping(value="/ticket",
			 consumes = {"application/json"},
			 produces = {"application/json"}
			)
	public ResponseEntity<Ticket>bookTicket(@RequestBody Passenger passenger){
		 Ticket ticket=service.bookTicket(passenger);
		return new ResponseEntity<>(ticket,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/ticket/{ticketnumb}",
			produces = {"application/json"}
			)
	public Ticket getTicket(@PathVariable Integer ticketnumb) {
		return service.getTicket(ticketnumb);
		
	}
	
}
