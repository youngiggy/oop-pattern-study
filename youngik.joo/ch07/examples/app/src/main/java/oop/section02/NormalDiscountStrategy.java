package oop.section02;

import oop.section02.DiscountStrategy;

public class NormalDiscountStrategy implements DiscountStrategy {
    @Override
    public double getDiscountPrice(double price) {
        return price;
    }

    @Override
    public double getDiscountRate() {
        return 1;
    }
}
