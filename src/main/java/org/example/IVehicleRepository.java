package org.example;

import java.util.List;

public interface IVehicleRepository {
    void rentCar(String plate);

    void returnCar(String plate);

    List<Vehicle> getVehicles();

    Vehicle getVehicle(String plate);

    void save(String path);

    void addVehicle(String type, String brand, String model, int year, double price, boolean rented, String plate, String category);

    void removeVehicle(String plate);
}

