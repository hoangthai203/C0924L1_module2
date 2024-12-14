package ss8_mvc.service;

import ss8_mvc.model.Client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClientService implements IClientService {

    private static Client[] clients = new Client[10];
    static {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        clients[0] = new Client(1, "Nguyễn Văn A", LocalDate.parse("16/12/2003", formatter), "Đà Nẵng");
        clients[1] = new Client(2, "Nguyễn Văn B", LocalDate.parse("16/12/2003", formatter), "Hà Nội");
        clients[2] = new Client(3, "Nguyễn Văn C", LocalDate.parse("16/12/2003", formatter), "Nha Trang");
    }

    @Override
    public Client[] findAll() {
        return clients;
    }

    @Override
    public void addClient(Client client) {
        for (int i = 0; i < clients.length; i++) {
            if (clients[i]==null) {
                clients[i] = client;
                break;
            }
        }
    }

    @Override
    public boolean updateClient(int id, String name, LocalDate birthDate, String address) {
        for (Client client : clients) {
            if (client != null && client.getId() == id) {
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
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null && clients[i].getId() == id) {
                clients[i] = null;
                return true;
            }
        }
        return false;
    }
}
