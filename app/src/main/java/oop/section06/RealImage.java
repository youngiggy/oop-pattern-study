package oop.section06;

public class RealImage implements Image {
    private final String path;

    public RealImage(String path) {
        this.path = path;
        System.out.println("Real image(" + path + ") loading...");
    }
    @Override
    public void draw() {
        System.out.println("Real image(" + path + ") drawing...");
    }
}
