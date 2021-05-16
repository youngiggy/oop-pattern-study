package oop.section12;

public class Light extends Device{
    @Override
    public void turnOnMyself() {
        System.out.println(this.getClass().getName() + " has turned on.");
    }

    @Override
    public void turnOffMyself() {
        System.out.println(this.getClass().getName() + " has turned off.");
    }

    @Override
    protected boolean canContainSubdevice() {
        return false;
    }
}
