package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerTest {

    TicketRepository productRepository = new TicketRepository();
    Manager manager = new Manager(productRepository);
    private Ticket toBelgrade = new Ticket(1, 185, 11_000, "DME", "EGO");
    private Ticket toAnkara = new Ticket(2, 160, 11_000, "VKO", "ANK");
    private Ticket toChicago = new Ticket(3, 780, 11_000, "DME", "CHI");
    private Ticket toRiga = new Ticket(4, 185, 11_000, "SVO", "RIX");



    @BeforeEach
    public void setUp() {
        manager.add(toBelgrade);
        manager.add(toAnkara);
        manager.add(toChicago);
        manager.add(toRiga);
    }

    @Test
    public void shouldAddItemsInRepository() {
        Ticket[] actual = manager.findAll();
        Ticket[] expected = new Ticket[]{toBelgrade, toAnkara, toChicago, toRiga};
        assertArrayEquals(expected, actual);
    }



}
