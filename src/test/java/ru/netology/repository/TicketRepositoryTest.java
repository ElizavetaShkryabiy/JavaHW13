package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketRepositoryTest {
  private TicketRepository repository = new TicketRepository();
  private Ticket toBelgrade = new Ticket(1, 185, 11_000, "DME", "EGO");
  private Ticket toAnkara = new Ticket(2, 160, 11_000, "VKO", "ANK");
  private Ticket toChicago = new Ticket(3, 780, 11_000, "DME", "CHI");
  private Ticket toRiga = new Ticket(4, 185, 11_000, "SVO", "RIX");


  @Test
  public void shouldSaveOneItem() {
    repository.save(toAnkara);

    Ticket[] expected = new Ticket[]{toAnkara};
    Ticket[] actual = repository.findAll();
    assertArrayEquals(expected, actual);
  }
  @Test
  public void shouldSaveAllItems() {
    repository.save(toBelgrade);
    repository.save(toAnkara);
    repository.save(toChicago);
    repository.save(toRiga);

    Ticket[] expected = new Ticket[]{toBelgrade, toAnkara, toChicago, toRiga};
    Ticket[] actual = repository.findAll();
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldRemoveById (){
    repository.save(toBelgrade);
    repository.save(toAnkara);
    repository.save(toChicago);
    repository.save(toRiga);
    Ticket[] expected = new Ticket[]{toBelgrade, toAnkara, toRiga};
    Ticket[] actual = repository.removeById(3);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldFindById () {
    repository.save(toBelgrade);
    repository.save(toAnkara);
    repository.save(toChicago);
    repository.save(toRiga);
    Ticket[] expected = new Ticket[]{toAnkara};
    Ticket[] actual = repository.findById(2);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldFindByNotExistingId () {
    repository.save(toBelgrade);
    repository.save(toAnkara);
    repository.save(toChicago);
    repository.save(toRiga);
    Ticket[] expected = null;
    Ticket[] actual = repository.findById(7);
    assertArrayEquals(expected, actual);
  }




}
