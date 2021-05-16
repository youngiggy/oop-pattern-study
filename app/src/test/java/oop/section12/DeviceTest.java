package oop.section12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeviceTest {
    @Test
    public void device_can_add_another_devices() {
        // Arrange
        Device device = new LightController();
        Device device2 = new LightController();
        Device device3 = new LightController();

        // Act
        device.addDevice(device2);
        device.addDevice(device3);

        // Assert
        assertEquals(2, device.getSubdevices().size());
    }

    @Test
    public void device_can_remove_subdevices() {
        // Arrange
        Device device = new LightController();
        Device device2 = new LightController();
        Device device3 = new LightController();
        device.addDevice(device2);
        device.addDevice(device3);

        // Act
        device.removeDevice(device3);

        // Assert
        assertEquals(1, device.getSubdevices().size());
    }

    @Test
    public void can_turn_on_and_off_subdevices() {
        // Arrange
        Device device = new LightController();
        var subdevice1 = spy(LightController.class);
        doNothing().when(subdevice1).turnOn();
        var subdevice2 = spy(LightController.class);
        doNothing().when(subdevice2).turnOn();
        device.addDevice(subdevice1);
        device.addDevice(subdevice2);

        // Act
        device.turnOn();

        // Assert
        verify(subdevice1).turnOn();
        verify(subdevice2).turnOn();
    }

    @Test
    public void can_turn_off_subdevices() {
        // Arrange
        Device device = new LightController();
        var subdevice1 = spy(LightController.class);
        doNothing().when(subdevice1).turnOff();
        var subdevice2 = spy(LightController.class);
        doNothing().when(subdevice2).turnOff();
        device.addDevice(subdevice1);
        device.addDevice(subdevice2);

        // Act
        device.turnOff();

        // Assert
        verify(subdevice1).turnOff();
        verify(subdevice2).turnOff();
    }

    @Test
    public void light_devices_cannot_have_subdevice() {
        // Arrange
        Device sut = new Light();
        Device lightUnit = new Light();

        // Act

        // Assert
        assertThrows(UnitDeviceCannotHaveSubdevicesException.class, () -> sut.addDevice(lightUnit));
        assertEquals(0, sut.getSubdevices().size());
    }

    @Test
    public void canTurnOnSubdevicesOfSubdevices() {
        // Arrange
        Device mainController = new LightController();
        Device controllerOfFloor1 = new LightController();
        Device controllerOfFloor2 = new LightController();

        Device lightUnitOf1Floor = new Light();
        var spyOf1Floor= spy(Light.class);
        doNothing().when(spyOf1Floor).turnOn();

        controllerOfFloor1.addDevice(lightUnitOf1Floor);
        controllerOfFloor1.addDevice(spyOf1Floor);

        Device lightUnitOf2Floor = new Light();
        var spyOf2Floor= spy(Light.class);
        doNothing().when(spyOf2Floor).turnOn();

        controllerOfFloor2.addDevice(lightUnitOf2Floor);
        controllerOfFloor2.addDevice(spyOf2Floor);

        mainController.addDevice(controllerOfFloor1);
        mainController.addDevice(controllerOfFloor2);

        // Act
        mainController.turnOn();

        // Assert
        verify(spyOf1Floor).turnOn();
        verify(spyOf2Floor).turnOn();
    }

    @Test
    public void canTurnOffSubdevicesOfSubdevices() {
        // Arrange
        Device mainController = new LightController();
        Device controllerOfFloor1 = new LightController();
        Device controllerOfFloor2 = new LightController();

        Device lightUnitOf1Floor = new Light();
        var spyOf1Floor= spy(Light.class);
        doNothing().when(spyOf1Floor).turnOff();

        controllerOfFloor1.addDevice(lightUnitOf1Floor);
        controllerOfFloor1.addDevice(spyOf1Floor);

        Device lightUnitOf2Floor = new Light();
        var spyOf2Floor= spy(Light.class);
        doNothing().when(spyOf2Floor).turnOff();

        controllerOfFloor2.addDevice(lightUnitOf2Floor);
        controllerOfFloor2.addDevice(spyOf2Floor);

        mainController.addDevice(controllerOfFloor1);
        mainController.addDevice(controllerOfFloor2);

        // Act
        mainController.turnOff();

        // Assert
        verify(spyOf1Floor).turnOff();
        verify(spyOf2Floor).turnOff();
    }
}


















