package ss18_case_study.mvc.service;

import ss18_case_study.mvc.model.Vehicle;

import java.util.List;

public interface IVehicleService {
    void addVehicle(Vehicle vehicle);
    void displayAllVehicles();
    boolean deleteVehicleByPlate(String plateNumber);
    List<Vehicle> loadVehiclesFromFile(String fileName);
}

