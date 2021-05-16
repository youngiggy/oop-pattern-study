package oop.section04;

public class Product {
    private final int id;
    private final int price;

    public Product(int id, int price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }
}
