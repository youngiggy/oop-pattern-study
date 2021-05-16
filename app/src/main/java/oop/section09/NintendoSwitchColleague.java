package oop.section09;

public class NintendoSwitchColleague extends Colleague {
    public NintendoSwitchColleague(Mediator m) {
        super(m);
    }

    public void receive(String message) {
        System.out.println("NintendoSwitch Received: " + message);
    }
}
