package org.example;

public class User {
    private String login;
    private String password;
    private String role;
    private Vehicle rentedVehicle;

    public User(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public Vehicle getRentedVehicle() {
        return rentedVehicle;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setRentedVehicle(Vehicle rentedVehicle) {
        this.rentedVehicle = rentedVehicle;
    }

    public String toCSV(){
        return login + "," + password + "," + role;
    }

    @Override
    public String toString(){
        return "login: " + login + " haslo: " + password + " rola: " + role + "\n";
    }
}
