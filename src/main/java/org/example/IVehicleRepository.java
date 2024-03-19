package org.example;

import java.util.List;

public interface IVehicleRepository {
    void rentCar(String plate);

    void returnCar(String plate);

    List<Vehicle> getVehicles();

    void save(String path);
}

