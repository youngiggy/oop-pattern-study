package oop.section08;

public class StatusEmailSender implements StatusObserver {
    @Override
    public void onAbnormalStatus(Status status) {
        //send Email
    }
}
