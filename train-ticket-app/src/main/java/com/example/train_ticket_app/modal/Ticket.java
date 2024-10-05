package com.example.train_ticket_app.modal;

public class Ticket {

	private String from;
	private String to;
	private User user;
	private double price;
	private String seatNumber;
	private String section;

	public Ticket(String from, String to, User user, double price, String seatNumber, String section) {
		super();
		this.from = from;
		this.to = to;
		this.user = user;
		this.price = price;
		this.seatNumber = seatNumber;
		this.section = section;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

}
