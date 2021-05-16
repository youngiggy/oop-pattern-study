# 12 컴포지트(Composite) 패턴

코드의 수정이나 확장을 어렵게 만드는 코드의 (거의 동일한) 중복을 해결
전체-부분을 구성하는 클래스가 동일 인터페이스를 구현

컴포지트 패턴에서 컴포지트는 다음의 책임을 갖는다
- 컴포넌트 그룹을 관리한다
- 컴포지트에 기능 실행을 요청하면, 컴포지트는 포함하고 있는 컴포지트에게 기능 실행 요청을 위임한다

## 테스트 계획

테스트에서 검토할 사항
- 단일 컴포지트와 컴포지트의 그룹을 모두 같은 인터페이스(abstract)로 제어할 것
  - canContain()으로 하위 디바이스 추가 가능 여부 확인
- 단일 컴포지트가 컴포지트 그룹에 속할 수 있고, 기능 실행 시 단일/그룹 모두의 기능이 실행되어야 함
- 그룹 컴포지트의 계층은 무한히 늘어날 수 있다

코딩 전 의문점
- 계층의 깊은 곳에서의 기능 실행 여부를 어떻게 확인할 수 있을까
    - spy를 한 계층으로 보내는 방식으로 여러 테스트를 작성하는 것도 괜찮을 듯

### TDD

```java
public abstract class Device {
    private List<Device> devices = new ArrayList<>();

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void removeDevice(Device device) {
        devices.remove(device);
    }

    public List<Device> getSubdevices() {
        return devices;
    }

    public abstract void turnOn();
    public abstract void turnOff();
}
```
이런 인터페이스로는 turnOn 했을 때 하위 디바이스까지 turnOn한다는 가정을 할 수 있을까?
자기 자신 만 turnOn하는 디바이스가 나타나면 composite이 깨진다.
그래서 일관된 동작을 보장할 수 있게 abstract 구현을 만들고, template method로 자신의 기능을 실행하도록 수정.
```java
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
```

