package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.InfoTicket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InfoTicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private InfoTicketManager manager = new InfoTicketManager(repository);

    private InfoTicket first = new InfoTicket(1, 2985, "KUF", "VKO", 45);
    private InfoTicket second = new InfoTicket(2, 3985, "KUF", "VKO", 50);
    private InfoTicket third = new InfoTicket(3, 1299, "SVO", "KZN", 95);
    private InfoTicket fourth = new InfoTicket(4, 2199, "VKO", "KZN", 95);
    private InfoTicket fifth = new InfoTicket(5, 2349, "VKO", "LED", 85);
    private InfoTicket sixth = new InfoTicket(6, 2646, "DME", "LED", 95);
    private InfoTicket seventh = new InfoTicket(7, 3790, "DME", "KUF", 90);
    private InfoTicket eighth = new InfoTicket(8, 3246, "DME", "LED", 95);

    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
    }

    @Test
    void shouldFindAllAndSort() {
        InfoTicket[] actual = repository.findAll();
        InfoTicket[] expected = new InfoTicket[]{third, fourth, fifth, sixth, first, eighth, seventh, second};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindTicket() {
        InfoTicket[] actual = manager.findAll("DME", "LED");
        InfoTicket[] expected = new InfoTicket[]{sixth, eighth};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldNotFindTicket() {
        InfoTicket[] actual = manager.findAll("SVO", "KUF");
        InfoTicket[] expected = new InfoTicket[0];
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldFindTicketAndSortByPrice() {
        InfoTicket[] actual = manager.findAll("KUF", "VKO");
        InfoTicket[] expected = new InfoTicket[]{first, second};
        assertArrayEquals(actual, expected);
    }
}