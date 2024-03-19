package org.example;

public class Main {
    public static void main(String[] args) {
        VehicleRepository vp = new VehicleRepository();

        //vp.rentCar("LU736KN");
        //vp.rentCar("LU222KN");

        vp.returnCar("LU736KN");
        //vp.returnCar("LU222KN");
    }
}