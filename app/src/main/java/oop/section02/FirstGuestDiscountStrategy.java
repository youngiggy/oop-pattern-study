package oop.section02;

import oop.section02.DiscountStrategy;

public class FirstGuestDiscountStrategy implements DiscountStrategy {
    @Override
    public double getDiscountPrice(double price) {
        return price * getDiscountRate();
    }

    @Override
    public double getDiscountRate() {
        return 0.3;
    }


}
