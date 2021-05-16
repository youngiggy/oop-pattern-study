package oop.section08;

public class StatusMessageSender implements StatusObserver {
    @Override
    public void onAbnormalStatus(Status status) {
        // send SMS
    }
}
