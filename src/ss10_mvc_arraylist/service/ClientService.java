package ss10_mvc_arraylist.service;

import ss10_mvc_arraylist.model.Client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientService implements IClientService {

    private static List<Client> clients = new ArrayList<>();
    static {
        clients.add(new Client(1, "Hoàng Thái", LocalDate.of(2003, 12, 16), "Đà Nẵng"));
        clients.add(new Client(2, "Hoàng Thái", LocalDate.of(2003, 12, 16), "Hà Nội"));
        clients.add(new Client(3, "Hoàng Thái", LocalDate.of(2003, 12, 16), "Huế"));
    }

    @Override
    public List<Client> findAll(){
        return clients;
    }

    @Override
    public void addClient(Client client) {
        clients.add(client);
    }

    @Override
    public boolean updateClient(int id, String name, LocalDate birthDate, String address) {
        for (Client client : clients) {
            if (client.getId() == id) {
                client.setName(name);
                client.setBirthDate(birthDate);
                client.setAddress(address);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteClient(int id) {
        return clients.removeIf(client -> client.getId() == id);
    }
}
