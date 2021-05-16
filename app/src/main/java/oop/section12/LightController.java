package oop.section12;

public class LightController extends Device{
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
        return true;
    }
}
