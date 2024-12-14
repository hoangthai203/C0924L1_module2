package ss8_mvc.model;

import java.time.LocalDate;

public class Client {
    private int id;
    private String name;
    private LocalDate birthDate;
    private String address;

    public Client() {
    }

    public Client(int id, String name, LocalDate birthDate, String address) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", Tên: '" + name + '\'' +
                ", Ngày tháng năm sinh: " + birthDate +
                ", Địa chỉ: '" + address + '\'' +
                '}';
    }
}
