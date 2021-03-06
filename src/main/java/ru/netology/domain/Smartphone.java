package ru.netology.domain;

public class Smartphone extends Product {


    private String manufacturer;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "manufacturer=" + manufacturer +
                '}';
    }

    public boolean matches(String search) {
        return super.matches(search) || this.getManufacturer().equalsIgnoreCase(search);
    }
}

