package oop.section08;

import java.util.ArrayList;
import java.util.List;

public class StatusChecker implements StatusSubsject {

    private final List<StatusObserver> observers = new ArrayList<>();

    public void check(Status status) {
        if (status.isNotNormal())
            notifyStatus(status);

    }

    @Override
    public void add(StatusObserver statusObserver) {
        observers.add(statusObserver);
    }

    @Override
    public void notifyStatus(Status status) {
        for(StatusObserver observer: observers) {
            observer.onAbnormalStatus(status);
        }
    }
}
