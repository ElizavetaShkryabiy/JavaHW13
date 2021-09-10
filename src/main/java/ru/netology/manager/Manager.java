package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;

public class Manager {
    private TicketRepository repository;

    public Manager(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket[] findAll() {
        Ticket[] product = repository.findAll();
        Arrays.sort(product);
        return product;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket product : repository.findAll()) {
            String expectedD = product.getDepartureAirport();
            String expectedA = product.getArrivalAirport();
            if (expectedD == from & expectedA == to) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
            Arrays.sort(result);
        }
        return result;

    }

    public Ticket[] searchBy(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];
        for (Ticket product : repository.findAll()) {
            String expectedD = product.getDepartureAirport();
            String expectedA = product.getArrivalAirport();
            if (expectedD.equals(from) & expectedA.equals(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
            Arrays.sort(result,comparator);
        }
        return result;

    }


}
