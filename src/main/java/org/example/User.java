package org.example;

import javax.management.relation.Role;

public class User {
    private String login;
    private String password;
    private Role role;
    private String rentedPlate;

    public User(String login, String password, Role role, String rentedPlate) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.rentedPlate = rentedPlate;
    }

    public User(String login, String password){
        this.login = login;
        this.password = password;
        this.role = Role.USER;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public String getRentedPlate() {
        return rentedPlate;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setRentedVehicle(String rentedVehicle) {
        this.rentedPlate = rentedVehicle;
    }

    public String toCSV(){
        return login + ";" + password + ";" + role + ";" + rentedPlate;
    }

    @Override
    public String toString(){
        return "login: " + login + " haslo: " + password + " rola: " + role + "tablica wypozyczonego samochodu: " + rentedPlate + "\n";
    }

    public enum Role {
        USER,ADMIN;
    }
}
