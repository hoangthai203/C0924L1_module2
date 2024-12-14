package ss8_mvc.service;

import ss8_mvc.model.Client;

import java.time.LocalDate;

public interface IClientService {
    Client[] findAll();

    void addClient(Client client);
    boolean updateClient(int id, String name, LocalDate birthDate, String address);
    boolean deleteClient(int id);
}
