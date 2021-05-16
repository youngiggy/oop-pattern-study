package oop.section02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void itCanCalculateNormalPrice() {
        DiscountStrategy strategy = new NormalDiscountStrategy();
        DiscountPriceCalculator sut = new DiscountPriceCalculator(strategy);

        double discountRate = strategy.getDiscountRate();
        List<Item> items = new ArrayList<>();
        double price1 = 3000;
        double price2 = 6000;
        items.add(new Item(price1));
        items.add(new Item(price2));

        double expectedPrice = price1 * discountRate + price2 * discountRate;
        assertEquals(expectedPrice, sut.calculate(items));
    }

    @Test
    void itCanCalculateFirstGuestPrice() {
        DiscountStrategy strategy = new FirstGuestDiscountStrategy();
        DiscountPriceCalculator sut = new DiscountPriceCalculator(strategy);

        double discountRate = strategy.getDiscountRate();
        List<Item> items = new ArrayList<>();
        double price1 = 3000;
        double price2 = 6000;
        items.add(new Item(price1));
        items.add(new Item(price2));

        double expectedPrice = price1 * discountRate + price2 * discountRate;
        assertEquals(expectedPrice, sut.calculate(items));
    }
}
