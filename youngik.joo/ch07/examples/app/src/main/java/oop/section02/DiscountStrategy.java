package oop.section02;

public interface DiscountStrategy {
    double getDiscountPrice(double price);
    double getDiscountRate();
}
