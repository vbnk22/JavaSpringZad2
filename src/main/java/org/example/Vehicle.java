package org.example;

public abstract class Vehicle {
    private String brand;
    private String model;
    private int year;
    private double price;
    private boolean rented;
    private String plate;

    public Vehicle(String brand, String model, int year, double price, boolean rented, String plate){
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.rented = rented;
        this.plate = plate;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public boolean isRented() {
        return rented;
    }

    public String getPlate() {
        return plate;
    }

    public abstract String toCSV();
}
