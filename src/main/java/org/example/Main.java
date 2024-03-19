package org.example;

public class Main {
    public static void main(String[] args) {
        VehicleRepository vp = new VehicleRepository();
        UserRepository up = new UserRepository();

        //vp.rentCar("LU736KN");
        //vp.rentCar("LU222KN");

        //vp.returnCar("LU736KN");
        //vp.returnCar("LU222KN");
        //vp.readCSV("C:\\Users\\olesz\\Desktop\\danne\\dane.txt");

        //vp.addVehicle("Car", "BMW", "Seria 3", 2021, 100000, false, "LKS12348", "A");

        //System.out.println(vp.getVehicles());

        //vp.removeVehicle("LKS12348");

        //System.out.println(vp.getVehicles());

        up.addUser(new User("test", "test123", "user"));
        up.addUser(new User("admin", "admin", "admin"));
        up.save("C:\\Users\\olesz\\Desktop\\danne\\users.txt");

        System.out.println(up.getUsers());
    }
}