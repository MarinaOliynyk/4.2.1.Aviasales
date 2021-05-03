package ru.netology.manager;

import ru.netology.domain.InfoTicket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class InfoTicketManager {
    private TicketRepository repository;

    public InfoTicketManager() {
    }

    public InfoTicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(InfoTicket infoTicket) {
        repository.save(infoTicket);
    }

    public InfoTicket[] findAll(String from, String to) {
        InfoTicket[] result = new InfoTicket[0];
        for (InfoTicket infoTicket : repository.findAll()) {
            if (infoTicket.matches(from, to)) {
                InfoTicket[] tmp = new InfoTicket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = infoTicket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
