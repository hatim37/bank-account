package net.hatim.accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.hatim.accountservice.model.Ticket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface TicketRestClient {
    @GetMapping("/tickets/{id}")
    @CircuitBreaker(name="ticketService", fallbackMethod = "getDefaultTickets")
    Ticket findTicketById(@PathVariable Long id);
    @GetMapping("/tickets")
    @CircuitBreaker(name="ticketService", fallbackMethod = "getAllTickets")
    List<Ticket> allTickets();

    default Ticket getDefaultTicket(Long id, Exception exception){
        Ticket customer = new Ticket();
        customer.setId(id);
        customer.setName("Non Trouvée");
        customer.setPlace(0);
        return customer;
    }

    default List<Ticket> getAllCustomers(Exception exception){
        return List.of();
    }

}
