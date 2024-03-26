package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleRepository implements IVehicleRepository{
    private final List<Vehicle> vehicles;

    public VehicleRepository(){
        this.vehicles = new ArrayList<>();
        readCSV("C:\\Users\\olesz\\Desktop\\danne\\dane.txt");
    }

    public void readCSV(String path) {
        File newFile = new File(path);

        try {
            Scanner sc = new Scanner(newFile);

            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] vehicle = line.split(";");

                if (vehicle[0].equals("Car")){
                    vehicles.add(new Car(vehicle[2], vehicle[3], Integer.parseInt(vehicle[4]), Double.parseDouble(vehicle[5]), Boolean.parseBoolean(vehicle[6]), vehicle[1]));
                } else if (vehicle[0].equals("Motorcycle")) {
                    vehicles.add(new Motorcycle(vehicle[2], vehicle[3], Integer.parseInt(vehicle[4]), Double.parseDouble(vehicle[5]), Boolean.parseBoolean(vehicle[6]), vehicle[1], vehicle[7]));
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rentCar(String plate) {
        readCSV("C:\\Users\\olesz\\Desktop\\danne\\dane.txt");
        for (var v: vehicles){
            if (v.getPlate().equals(plate)){
                v.setRented(true);
                save("C:\\Users\\olesz\\Desktop\\danne\\zapis.txt");
            }
        }
    }

    @Override
    public void returnCar(String plate) {
        readCSV("C:\\Users\\olesz\\Desktop\\danne\\dane.txt");
        for (var v: vehicles){
            if (v.getPlate().equals(plate)){
                v.setRented(false);
                save("C:\\Users\\olesz\\Desktop\\danne\\zapis.txt");
            }
        }
    }

    @Override
    public void save(String path) {
        File newFile = new File(path);

        try{
            if (!newFile.exists()){
                newFile.createNewFile();
            }

            FileWriter fw = new FileWriter(path);
            fw.write("");
            for (var v: vehicles) {
                fw.write(v.toCSV() + "\n");
            }
            fw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public void addVehicle(String type, String brand, String model, int year, double price, boolean rented, String plate, String category){
        if (type.equals("Car")){
            Car car = new Car(brand, model, year, price, rented, plate);
            for (var v: vehicles){
                if (v.equals(car)){
                    return;
                }
            }
            vehicles.add(car);
        }
        else if (type.equals("Motorcycle")){
            Motorcycle motorcycle = new Motorcycle(brand, model, year, price, rented, plate, category);
            for (var v: vehicles){
                if (v.equals(motorcycle)){
                    return;
                }
            }
            vehicles.add(motorcycle);
        }
        save("C:\\Users\\olesz\\Desktop\\danne\\dane.txt");
    }

    @Override
    public void removeVehicle(String plate){
        for (int i = 0; i < vehicles.size(); i++){
            Vehicle vehicle = vehicles.get(i);
            if (vehicle.getPlate().equals(plate)){
                vehicles.remove(vehicle);
            }
        }
        save("C:\\Users\\olesz\\Desktop\\danne\\dane.txt");
    }

    @Override
    public Vehicle getVehicle(String plate){
        for (Vehicle v: vehicles){
            if (v.getPlate().equals(plate)){
                return v;
            }
        }
        return null;
    }
}
