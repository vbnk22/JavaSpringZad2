package org.example;

public class Main {
    public static void main(String[] args) {
        VehicleRepository vp = new VehicleRepository();

        //vp.rentCar("LU736KN");
        //vp.rentCar("LU222KN");

        //vp.returnCar("LU736KN");
        //vp.returnCar("LU222KN");
        //vp.readCSV("C:\\Users\\olesz\\Desktop\\danne\\dane.txt");

        vp.addVehicle("Car", "BMW", "Seria 3", 2021, 100000, false, "LKS12348", "A");

        System.out.println(vp.getVehicles());

        vp.removeVehicle("LKS12348");

        System.out.println(vp.getVehicles());
    }
}