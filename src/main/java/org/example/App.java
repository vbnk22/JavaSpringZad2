package org.example;

import java.util.Scanner;

public class App {
    public static  User user = null;
    public final UserRepository ur = new UserRepository();
    public final VehicleRepository vr = new VehicleRepository();
    private final Scanner scanner = new Scanner(System.in);

    public void run() {

        System.out.println("LOG IN");

        user = Authenticator.login(scanner.nextLine(), scanner.nextLine());
        if(user!=null){
            System.out.println("logged in!!");

            String response = "";
            boolean running=true;
            while(running) {

                if(user.getRole().toString().equals("USER")){
                    System.out.println("00 - show info");
                    System.out.println("1 - rent car");
                    System.out.println("2 - return car");

                    response = scanner.nextLine();

                    switch (response) {
                        case "00":
                            System.out.println(user);
                            if (!(user.getRentedPlate() == "null")){
                                System.out.println(vr.getVehicle(user.getRentedPlate()));
                            }
                            else{
                                System.out.println("Brak wypozyczonego auta");
                            }
                            break;
                        case "1":
                            System.out.println("plate: ");
                            String line = scanner.nextLine();
                            vr.rentCar(line);
                            user.setRentedPlate(line);
                            System.out.println("Car rented");
                            break;
                        case "2":
                            vr.returnCar(user.getRentedPlate());
                            user.setRentedPlate("");
                            System.out.println("Car returned");
                            break;
                    }
                } else if (user.getRole().toString().equals("ADMIN")) {
                    System.out.println("000 - show users");
                    System.out.println("0 - show vehicles");
                    System.out.println("1 - add vehicle");
                    System.out.println("2 - remove vehicle");

                    response = scanner.nextLine();

                    switch (response){
                        case "000":
                            for (User u: ur.getUsers()){
                                System.out.println(u);
                                if (!(user.getRentedPlate() == "null")){
                                    System.out.println(vr.getVehicle(u.getRentedPlate()));
                                }
                            }
                            break;
                        case "0":
                            System.out.println(vr.getVehicles());
                            break;
                        case "1":
                            System.out.println("enter vehicle: type;brand;model;year;price;rented;plate;category");
                            String line = scanner.nextLine();
                            String[] vehicle = line.split(";");
                            vr.addVehicle(vehicle[0], vehicle[1], vehicle[2], Integer.parseInt(vehicle[3]), Double.parseDouble(vehicle[4]), Boolean.parseBoolean(vehicle[5]), vehicle[6], vehicle[7]);
                            System.out.println("Vehicle added");
                            break;
                        case "2":
                            System.out.println("plate:");
                            String linePlate = scanner.nextLine();
                            vr.removeVehicle(linePlate);
                            System.out.println("Car removed");
                            break;
                    }
                }

            }
        }else{
            System.out.println("Bledne dane!");
        }
        System.exit(0);
    }
}
