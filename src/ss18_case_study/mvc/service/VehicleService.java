package ss18_case_study.mvc.service;

import ss18_case_study.mvc.model.Car;
import ss18_case_study.mvc.model.Motorcycle;
import ss18_case_study.mvc.model.Truck;
import ss18_case_study.mvc.model.Vehicle;
import ss18_case_study.mvc.util.ReadAndWrite;

import java.util.List;
import java.util.ArrayList;

public class VehicleService {

    private final String CAR_FILE = "src/ss18_case_study/mvc/data/oto.csv";
    private final String TRUCK_FILE = "src/ss18_case_study/mvc/data/xeTai.csv";
    private final String MOTORCYCLE_FILE = "src/ss18_case_study/mvc/data/xeMay.csv";

    public void addVehicle(Vehicle vehicle) {
        String fileName = getFileName(vehicle);
        List<String> data = new ArrayList<>();
        data.add(vehicle.toCSV());
        ReadAndWrite.writeFile(fileName, data, true);
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.addAll(readVehicleFromFile(CAR_FILE, Car.class));
        vehicles.addAll(readVehicleFromFile(TRUCK_FILE, Truck.class));
        vehicles.addAll(readVehicleFromFile(MOTORCYCLE_FILE, Motorcycle.class));
        return vehicles;
    }

    public boolean deleteVehicleByLicensePlate(String licensePlate) {
        boolean isDeleted = false;
        isDeleted |= deleteVehicleFromList(CAR_FILE, licensePlate);
        isDeleted |= deleteVehicleFromList(TRUCK_FILE, licensePlate);
        isDeleted |= deleteVehicleFromList(MOTORCYCLE_FILE, licensePlate);
        return isDeleted;
    }

    private List<Vehicle> readVehicleFromFile(String fileName, Class<?> vehicleClass) {
        List<String> lines = ReadAndWrite.readFile(fileName);
        List<Vehicle> vehicles = new ArrayList<>();

        for (String line : lines) {
            Vehicle vehicle = createVehicleFromCSV(line, vehicleClass);
            if (vehicle != null) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    private boolean deleteVehicleFromList(String fileName, String licensePlate) {
        List<String> lines = ReadAndWrite.readFile(fileName);
        boolean found = false;
        List<String> updatedList = new ArrayList<>();

        for (String line : lines) {
            if (!line.contains(licensePlate)) {
                updatedList.add(line);
            } else {
                found = true;
            }
        }

        if (found) {
            ReadAndWrite.writeFile(fileName, updatedList, false);
        }
        return found;
    }

    private Vehicle createVehicleFromCSV(String csvLine, Class<?> vehicleClass) {
        String[] data = csvLine.split(",");
        try {
            if (vehicleClass == Car.class) {
                return new Car(data[0], data[1], Integer.parseInt(data[2]), data[3],
                        Integer.parseInt(data[4]), data[5]);
            } else if (vehicleClass == Truck.class) {
                return new Truck(data[0], data[1], Integer.parseInt(data[2]), data[3],
                        Double.parseDouble(data[4]));
            } else if (vehicleClass == Motorcycle.class) {
                return new Motorcycle(data[0], data[1], Integer.parseInt(data[2]), data[3],
                        Double.parseDouble(data[4]));
            }
        } catch (Exception e) {
            System.out.println("Lỗi chuyển đổi dữ liệu từ CSV: " + e.getMessage());
        }
        return null;
    }

    private String getFileName(Vehicle vehicle) {
        if (vehicle instanceof Car) return CAR_FILE;
        if (vehicle instanceof Truck) return TRUCK_FILE;
        if (vehicle instanceof Motorcycle) return MOTORCYCLE_FILE;
        return null;
    }
}



