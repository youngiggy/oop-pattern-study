package oop.section04;

public class SelectableState implements State {
    public final VendingMachineState state = VendingMachineState.SELECTABLE;

    @Override
    public VendingMachineState getStateType() {
        return state;
    }

    @Override
    public void increaseCoin(int coin, VendingMachine vm) {
        vm.increaseCoin(coin);
    }

    @Override
    public void select(int productId, VendingMachine vm) {
        int price = vm.getProduct(productId).getPrice();

        if (price > vm.getCurrentCoin()) {
            SoundUtil.beep();
            return;
        }

        vm.decreaseCoin(price);
        vm.provideProduct(productId);

        if (vm.getCurrentCoin() == 0) {
            vm.changeState(new NoCoinState());
        }
    }
}
