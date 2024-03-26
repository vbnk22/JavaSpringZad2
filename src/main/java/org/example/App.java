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
                            if (!user.getRentedPlate().isEmpty()){
                                System.out.println(vr.getVehicle(user.getRentedPlate()));
                            }
                            break;
                    }
                } else if (user.getRole().toString().equals("ADMIN")) {
                    System.out.println("000 - show users");
                    System.out.println("0 - show cars");
                    System.out.println("1 - rent car");
                    System.out.println("2 - return car");
                    System.out.println("6 - add car");
                    System.out.println("7 - remove car");
                    System.out.println("8 - add user");
                    System.out.println("9 - remove user");

                    response = scanner.nextLine();
                }

            }
        }else{
            System.out.println("Bledne dane!");
        }
        System.exit(0);
    }
}
