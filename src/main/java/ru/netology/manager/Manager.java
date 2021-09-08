package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class Manager {
    private TicketRepository repository;

    public Manager(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket[] findAll() {
        Ticket[] product = repository.findAll();
        return product;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket product : repository.findAll()) {
            if (product.getDepartureAirport() == from & product.getArrivalAirport() == to) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;

    }


}
