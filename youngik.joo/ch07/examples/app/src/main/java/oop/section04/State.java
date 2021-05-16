package oop.section04;

public interface State {
    public VendingMachineState getStateType();
    public void increaseCoin(int coin, VendingMachine vm);
    public void select(int productId, VendingMachine vm);
}
