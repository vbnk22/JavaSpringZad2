package org.example;

public class Car extends Vehicle{

    public Car(String brand, String model, int year, double price, boolean rented, String plate) {
        super(brand, model, year, price, rented, plate);
    }

    @Override
    public String toCSV(){
        return "Car;" + super.getPlate() + ";" + super.getBrand() + ";" + super.getModel() + ";" + super.getYear() + ";" + super.getPrice() + ";" + super.isRented();
    }

    @Override
    public String toString(){
        return "Marka: " + super.getBrand() + "\n" + " Model: " + super.getModel() + "\n" + " Rok produkcji: " + super.getYear() + "\n" + " Cena: " + super.getPrice() + "\n" + " Czy zostal wypozyczony: " + super.isRented() + "\n" + " O numerze rejestracyjnym: " + super.getPlate() + "\n";
    }
}

