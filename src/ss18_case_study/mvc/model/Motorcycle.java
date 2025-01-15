package ss18_case_study.mvc.model;

public class Motorcycle extends Vehicle {
    private double enginePower; // in horsepower

    public Motorcycle(String licensePlate, String manufacturer, int year, String owner, double enginePower) {
        super(licensePlate, manufacturer, year, owner);
        this.enginePower = enginePower;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    @Override
    public String toCSV() {
        return licensePlate + "," + manufacturer + "," + year + "," + owner + "," + enginePower;
    }

    @Override
    public String toString() {
        return "Motorcycle { " +
                "Biển số xe='" + licensePlate + '\'' +
                ", Nhà sản xuất='" + manufacturer + '\'' +
                ", Năm sản xuất=" + year +
                ", Chủ sở hữu='" + owner + '\'' +
                ", Công suất=" + enginePower +
                '}';
    }
}
