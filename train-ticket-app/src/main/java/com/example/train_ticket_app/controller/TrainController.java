package com.example.train_ticket_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.train_ticket_app.modal.Ticket;
import com.example.train_ticket_app.modal.User;
import com.example.train_ticket_app.service.TrainService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/train")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @PostMapping("/purchase")
    public Ticket purchaseTicket(@RequestBody User user) {
        return trainService.purchaseTicket(user);
    }

    @GetMapping("/receipt/{email}")
    public Ticket getReceipt(@PathVariable String email) {
        Optional<Ticket> ticket = trainService.getTicketByEmail(email);
        return ticket.orElse(null);
    }

    @GetMapping("/section/{section}")
    public List<Ticket> getTicketsBySection(@PathVariable String section) {
        return trainService.getTicketsBySection(section);
    }

    @DeleteMapping("/remove/{email}")
    public String removeUser(@PathVariable String email) {
        boolean removed = trainService.removeUser(email);
        return removed ? "User removed successfully." : "User not found.";
    }

    @PutMapping("/modify-seat")
    public String modifySeat(@RequestParam String email, @RequestParam String newSeatNumber, @RequestParam String newSection) {
        boolean modified = trainService.modifySeat(email, newSeatNumber, newSection);
        return modified ? "Seat modified successfully." : "User not found.";
    }
}
