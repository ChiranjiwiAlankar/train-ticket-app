package com.example.train_ticket_app.service;

import org.springframework.stereotype.Service;

import com.example.train_ticket_app.modal.Ticket;
import com.example.train_ticket_app.modal.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TrainService {
	private List<Ticket> tickets = new ArrayList<>();
	private int seatCounter = 1;

	public Ticket purchaseTicket(User user) {
		String seatNumber = "S" + seatCounter++;
		String section = seatCounter % 2 == 0 ? "B" : "A";
		Ticket ticket = new Ticket("London", "France", user, 20.0, seatNumber, section);
		tickets.add(ticket);
		return ticket;
	}

	public Optional<Ticket> getTicketByEmail(String email) {
		return tickets.stream().filter(ticket -> ticket.getUser().getEmail().equals(email)).findFirst();
	}

	public List<Ticket> getTicketsBySection(String section) {
		List<Ticket> sectionTickets = new ArrayList<>();
		for (Ticket ticket : tickets) {
			if (ticket.getSection().equalsIgnoreCase(section)) {
				sectionTickets.add(ticket);
			}
		}
		return sectionTickets;
	}

	public boolean removeUser(String email) {
		return tickets.removeIf(ticket -> ticket.getUser().getEmail().equals(email));
	}

	public boolean modifySeat(String email, String newSeatNumber, String newSection) {
		Optional<Ticket> ticketOptional = getTicketByEmail(email);
		if (ticketOptional.isPresent()) {
			Ticket ticket = ticketOptional.get();
			ticket.setSeatNumber(newSeatNumber);
			ticket.setSection(newSection);
			return true;
		}
		return false;
	}
}