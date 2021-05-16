package oop.section04;

public class NoCoinState implements State {
    public final VendingMachineState state = VendingMachineState.NO_COIN;

    @Override
    public VendingMachineState getStateType() {
        return state;
    }

    @Override
    public void increaseCoin(int coin, VendingMachine vm) {
        vm.increaseCoin(coin);
        vm.changeState(new SelectableState());
    }

    @Override
    public void select(int productId, VendingMachine vm) {
        SoundUtil.beep();
    }
}
