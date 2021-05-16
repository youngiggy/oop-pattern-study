package oop.section12;

import java.util.ArrayList;
import java.util.List;

public abstract class Device {
    private List<Device> devices = new ArrayList<>();

    public void addDevice(Device device) {
        if (!this.canContainSubdevice()) {
            throw new UnitDeviceCannotHaveSubdevicesException();
        }
        devices.add(device);
    }

    public void removeDevice(Device device) {
        devices.remove(device);
    }

    public List<Device> getSubdevices() {
        return devices;
    }

    protected abstract void turnOnMyself();
    public void turnOn() {
        turnOnMyself();
        for (Device device : devices) {
            device.turnOn();
        }
    }

    protected abstract void turnOffMyself();
    public void turnOff() {
        turnOffMyself();
        for (Device device : devices) {
            device.turnOff();
        }
    }

    protected abstract boolean canContainSubdevice();
}
