package ss18_case_study.mvc.model;

public class Truck extends Vehicle {
    private double loadCapacity; // in tons

    public Truck(String licensePlate, String manufacturer, int year, String owner, double loadCapacity) {
        super(licensePlate, manufacturer, year, owner);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toCSV() {
        return licensePlate + "," + manufacturer + "," + year + "," + owner + "," + loadCapacity;
    }

    @Override
    public String toString() {
        return "Truck { " +
                "Biển số xe='" + licensePlate + '\'' +
                ", Nhà sản xuất='" + manufacturer + '\'' +
                ", Năm sản xuất=" + year +
                ", Chủ sở hữu='" + owner + '\'' +
                ", Trọng tải=" + loadCapacity +
                '}';
    }
}
