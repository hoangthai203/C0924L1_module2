package ss18_case_study.mvc.model;

public class Car extends Vehicle {
    private int seatCount;
    private String type; // Sedan, SUV, etc.

    public Car(String licensePlate, String manufacturer, int year, String owner, int seatCount, String type) {
        super(licensePlate, manufacturer, year, owner);
        this.seatCount = seatCount;
        this.type = type;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toCSV() {
        return licensePlate + "," + manufacturer + "," + year + "," + owner + "," + seatCount + "," + type;
    }

    @Override
    public String toString() {
        return "Car { " +
                "Biển số xe='" + licensePlate + '\'' +
                ", Nhà sản xuất='" + manufacturer + '\'' +
                ", Năm sản xuất=" + year +
                ", Chủ sở hữu='" + owner + '\'' +
                ", Số chỗ ngồi=" + seatCount +
                ", Kiểu xe='" + type + '\'' +
                '}';
    }
}

