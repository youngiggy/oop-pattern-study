package oop.section08;

public interface StatusSubsject {
    void add(StatusObserver statusObserver);
    void notifyStatus(Status status);
}
