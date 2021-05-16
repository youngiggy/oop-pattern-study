package oop.section09;

public abstract class Colleague {
    private final Mediator mediator;

    public Colleague(Mediator m) {
        mediator = m;
    }

    //send a message via the mediator
    public void send(String message) {
        mediator.send(message, this);
    }

    public abstract void receive(String message);
}
