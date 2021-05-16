package oop.section02;

import java.util.List;

public class DiscountPriceCalculator {
    private DiscountStrategy strategy;

    public  DiscountPriceCalculator(DiscountStrategy strategy) {
        this.strategy = strategy;
    }
    public double calculate(List<Item> items) {
        double calculatedPrice = 0;
        for (Item item : items) {
            calculatedPrice += strategy.getDiscountPrice(item.getPrice());
        }
        return calculatedPrice;
    }
}
