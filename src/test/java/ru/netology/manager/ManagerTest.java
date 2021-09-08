package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerTest {

    TicketRepository productRepository = new TicketRepository();
    Manager manager = new Manager(productRepository);
    private Ticket toBelgrade = new Ticket(1, 185, 9_000, "DME", "EGO");
    private Ticket toAnkara = new Ticket(2, 160, 11_000, "VKO", "ANK");
    private Ticket toChicago = new Ticket(3, 780, 35_000, "DME", "CHI");
    private Ticket toRiga = new Ticket(4, 185, 5_000, "SVO", "RIX");
    private Ticket toAnkara2 = new Ticket(5, 100, 11_000, "VKO", "ANK");



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
        Ticket[] expected = new Ticket[]{toRiga, toBelgrade, toAnkara, toChicago};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindWhenOneItemIsTrue (){
        Ticket[] actual = manager.searchBy("VKO", "ANK");
        Ticket[] expected = new Ticket[]{toAnkara};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindWhenOnlyOneParameterIsTrue (){

        Ticket[] actual = manager.searchBy("DME", "EGO");
        Ticket[] expected = new Ticket[]{toBelgrade};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }





    @Test
    public void shouldFindBestTime(){
        manager.add(toAnkara2);
        Ticket[] actual = manager.searchBy("VKO","ANK", toAnkara);
        Ticket[] expected = new Ticket[]{toAnkara2,toAnkara};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }


}
