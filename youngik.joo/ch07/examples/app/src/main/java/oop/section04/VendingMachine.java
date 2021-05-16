package oop.section04;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private State state;
    private List<Product> products;
    private int coin = 0;

    public VendingMachine(List<Product> products) {
        state = new NoCoinState();
        this.products = products;
    }

    public VendingMachineState getCurrentStateType() {
        return state.getStateType();
    }

    public void insertCoin(int coin) {
        state.increaseCoin(coin, this);
    }

    public int getCurrentCoin() {
        return coin;
    }

    public void increaseCoin(int coin) {
        this.coin += coin;
    }

    public void select(int productId) {
        state.select(productId, this);
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void provideProduct(int productId) {
        System.out.println("You've got product #" + productId);
    }

    public void decreaseCoin(int coin) {
        this.coin -= coin;
    }

    public Product getProduct(int productId) {
        for (Product product : products) {
            if (product.getId() == productId)
                return product;
        }

        throw new RuntimeException("cannot find product of id #" + productId);
    }
}
