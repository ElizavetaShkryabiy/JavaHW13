package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerTest {

    TicketRepository productRepository = new TicketRepository();
    Manager manager = new Manager(productRepository);
    private Ticket toBelgrade = new Ticket(1, 185, 13_000, "DME", "EGO");
    private Ticket toBelgrade2 = new Ticket(5, 150, 10_000, "DME", "EGO");
    private Ticket toAnkara = new Ticket(2, 80, 180_000, "VKO", "ANK");
    private Ticket toChicago = new Ticket(3, 600, 50_000, "DME", "CHI");
    private Ticket toChicago2 = new Ticket(6, 780, 35_000, "DME", "CHI");
    private Ticket toRiga = new Ticket(4, 185, 5_000, "SVO", "RIX");


    @BeforeEach
    public void setUp() {
        manager.add(toBelgrade);
        manager.add(toBelgrade2);
        manager.add(toAnkara);
        manager.add(toChicago);
        manager.add(toChicago2);
        manager.add(toRiga);
    }

    @Test
    public void shouldAddItemsInRepository() {
        Ticket[] actual = manager.findAll();
        Ticket[] expected = new Ticket[]{toRiga, toBelgrade2, toBelgrade, toChicago2, toChicago, toAnkara};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindWhenOneItemIsTrue() {
        Ticket[] actual = manager.searchBy("VKO", "ANK");
        Ticket[] expected = new Ticket[]{toAnkara};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindWhenOnlyOneParameterIsTrue() {

        Ticket[] actual = manager.searchBy("DME", "EGO");
        Ticket[] expected = new Ticket[]{toBelgrade2,toBelgrade};

        assertArrayEquals(expected, actual);
    }


}
