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

    private InfoTicket first = new InfoTicket(1, 3985, "KUF", "VKO", 45);
    private InfoTicket second = new InfoTicket(2, 2985, "KUF", "VKO", 50);
    private InfoTicket third = new InfoTicket(3, 1299, "SVO", "KZN", 95);
    private InfoTicket fourth = new InfoTicket(4, 2199, "VKO", "KZN", 95);
    private InfoTicket fifth = new InfoTicket(5, 2349, "VKO", "LED", 85);
    private InfoTicket sixth = new InfoTicket(6, 3246, "DME", "LED", 95);
    private InfoTicket seventh = new InfoTicket(7, 3790, "DME", "KUF", 90);
    private InfoTicket eighth = new InfoTicket(8, 4315, "DME", "LED", 90);
    private InfoTicket ninth = new InfoTicket(9, 3613, "KUF", "VKO", 110);
    private InfoTicket tenth = new InfoTicket(10, 3846, "DME", "LED", 95);
    private InfoTicket eleventh = new InfoTicket(11, 3385, "KUF", "VKO", 109);
    private InfoTicket twelfth = new InfoTicket(12, 4721, "DME", "LED", 95);
    private InfoTicket thirteenth = new InfoTicket(13, 6840, "KUF", "VKO", 455);
    private InfoTicket fourteenth = new InfoTicket(14, 2646, "DME", "LED", 95);
    private InfoTicket fifteenth = new InfoTicket(15, 2599, "KUF", "VKO", 45);
    private InfoTicket sixteenth = new InfoTicket(16, 3161, "DME", "LED", 95);

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
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);
        manager.add(thirteenth);
        manager.add(fourteenth);
        manager.add(fifteenth);
        manager.add(sixteenth);
    }

    @Test
    void shouldFindAllAndSort() {
        InfoTicket[] actual = repository.findAll();
        InfoTicket[] expected = new InfoTicket[]{third, fourth, fifth, fifteenth, fourteenth, second, sixteenth, sixth, eleventh, ninth, seventh, tenth, first, eighth, twelfth, thirteenth};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindTicket() {
        InfoTicket[] actual = manager.findAll("DME", "LED");
        InfoTicket[] expected = new InfoTicket[]{fourteenth, sixteenth, sixth, tenth, eighth, twelfth};
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
        InfoTicket[] expected = new InfoTicket[]{fifteenth, second, eleventh, ninth, first, thirteenth};
        assertArrayEquals(actual, expected);
    }
}