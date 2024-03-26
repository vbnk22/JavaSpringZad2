package org.example;

public class Main {
    public static void main(String[] args) {
        UserRepository ur = new UserRepository();
        ur.addUser(new User("admin", "admin", User.Role.ADMIN, "LU74372"));
        App app = new App();
        app.run();
    }
}