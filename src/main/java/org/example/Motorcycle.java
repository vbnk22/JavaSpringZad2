package org.example;

public class Motorcycle extends Vehicle{
    private String category;

    public Motorcycle(String brand, String model, int year, double price, boolean rented, String plate, String category) {
        super(brand, model, year, price, rented, plate);
        this.category = category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toCSV(){
        return "Motorcycle;" + super.getPlate() + ";" + super.getBrand() + ";" + super.getModel() + ";" + super.getYear() + ";" + super.getPrice() + ";" + super.isRented() + ";" + getCategory();
    }

    @Override
    public String toString(){
        return "Marka: " + super.getBrand() + "\n" + " Model: " + super.getModel() + "\n" + " Rok produkcji: " + super.getYear() + "\n" + " Cena: " + super.getPrice() + "\n" + " Czy zostal wypozyczony: " + super.isRented() + "\n" + " O numerze rejestracyjnym: " + super.getPlate() + "\n" + "Wymagana kategoria prawa jazdy: " + getCategory() + "\n";
    }
}

