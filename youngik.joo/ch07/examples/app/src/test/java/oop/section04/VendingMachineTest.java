package oop.section04;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VendingMachineTest {

    private List<Product> makeDefaultProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, 10));
        products.add(new Product(2, 20));
        return products;
    }

    @Test
    void canGetProduct() {
        List<Product> products = new ArrayList<>();
        int product1Id = 1;
        int product1Price = 10;
        int product2Id = 2;
        int product2Price = 20;
        products.add(new Product(product1Id, product1Price));
        products.add(new Product(product2Id, product2Price));
        VendingMachine sut = new VendingMachine(products);

        assertEquals(sut.getProduct(product2Id).getPrice(), product2Price);

        int notExistingId = 0;
        assertThrows(RuntimeException.class, () -> sut.getProduct(notExistingId));
    }

    @Test
    void isNoCoinStatusWhenVendingMachineCreated() {
        VendingMachine sut = new VendingMachine(makeDefaultProducts());
        assertEquals(VendingMachineState.NO_COIN, sut.getCurrentStateType());
    }

    @Test
    void coinIsZeroWhenVendingMachineCreated() {
        VendingMachine sut = new VendingMachine(makeDefaultProducts());
        assertEquals(0, sut.getCurrentCoin());
    }

    @Test
    void canIncreaseCoinByInsertingCoinWhenNoCoinState() {
        VendingMachine sut = new VendingMachine(makeDefaultProducts());
        sut.changeState(new NoCoinState());
        int coinToIncrease = 1;

        sut.insertCoin(coinToIncrease);

        assertEquals(coinToIncrease, sut.getCurrentCoin());
    }

    @Test
    void isSelectableStateAfterInsertingCoinWhenNoCoinState() {
        VendingMachine sut = new VendingMachine(makeDefaultProducts());
        sut.changeState(new NoCoinState());
        int coinToIncrease = 1;

        sut.insertCoin(coinToIncrease);

        assertEquals(VendingMachineState.SELECTABLE, sut.getCurrentStateType());
    }

    @Test @Disabled
    void beepIfSelectingWhenNoCoinState() {
        //todo static method beep을 사용하기 때문에 테스트가 어려움
    }

    @Test
    void canIncreaseCoinByInsertingCoinWhenSelectableState() {
        VendingMachine sut = new VendingMachine(makeDefaultProducts());
        sut.changeState(new SelectableState());
        int coinToIncrease = 1;

        sut.insertCoin(coinToIncrease);

        assertEquals(coinToIncrease, sut.getCurrentCoin());
    }

    @Test @Disabled
    void canProvideProductBySelectingWhenSelectableState() {
        VendingMachine sut = new VendingMachine(makeDefaultProducts());
        sut.changeState(new SelectableState());
        int productId = 1;
        int coinToIncrease = 100;
        sut.insertCoin(coinToIncrease);

        sut.select(productId);

        //todo provideProduct() 실행 여부를 테스트 해야하나?
    }

    @Test
    void canDecreaseCoinBySelectingWhenSelectableState() {
        List<Product> products = new ArrayList<>();
        int product1Id = 1;
        int product1Price = 10;
        int product2Id = 2;
        int product2Price = 20;
        products.add(new Product(product1Id, product1Price));
        products.add(new Product(product2Id, product2Price));
        VendingMachine sut = new VendingMachine(products);
        sut.changeState(new SelectableState());
        int coinToIncrease = 100;
        sut.insertCoin(coinToIncrease);

        sut.select(product1Id);

        assertEquals(coinToIncrease - product1Price, sut.getCurrentCoin());
        int currntCoin = sut.getCurrentCoin();
        sut.select(product2Id);
        assertEquals(currntCoin - product2Price, sut.getCurrentCoin());
    }

    @Test
    void cannotDecreaseCoinIfCoinsNotEnoughOnSelectingWhenSelectableState() {
        List<Product> products = new ArrayList<>();
        int product1Id = 1;
        int product1Price = 10;
        products.add(new Product(product1Id, product1Price));
        VendingMachine sut = new VendingMachine(products);
        sut.changeState(new SelectableState());
        int coinToIncrease = 9;
        sut.insertCoin(coinToIncrease);

        sut.select(product1Id);

        //todo assert beep!

        assertEquals(coinToIncrease, sut.getCurrentCoin());
    }

    @Test
    void isNoCoinStateAfterSelectingWithAllPossibleCoinsWhenSelectableState() {
        List<Product> products = new ArrayList<>();
        int product1Id = 1;
        int product1Price = 10;
        products.add(new Product(product1Id, product1Price));
        VendingMachine sut = new VendingMachine(products);
        sut.changeState(new SelectableState());
        int coinToIncrease = 10;
        sut.insertCoin(coinToIncrease);

        sut.select(product1Id);

        assertEquals(VendingMachineState.NO_COIN, sut.getCurrentStateType());
    }

    //todo SOLD_OUT 상태 객체
}
