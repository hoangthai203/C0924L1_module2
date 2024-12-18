package ss10_mvc_arraylist.service;

import ss10_mvc_arraylist.model.Client;

import java.time.LocalDate;
import java.util.List;

public interface IClientService {
    List<Client> findAll();

    void addClient(Client client);
    boolean updateClient(int id, String name, LocalDate birthDate, String address);
    boolean deleteClient(int id);
}
