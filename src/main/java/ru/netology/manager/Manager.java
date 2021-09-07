package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

public class Manager {
    private TicketRepository repository;

    public Manager(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket[] findAll() {
        Ticket[] product = repository.findAll();
        return product;
    }

    public void add(Ticket product) {
        repository.save(product);
    }


}
