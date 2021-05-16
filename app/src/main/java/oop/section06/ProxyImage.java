package oop.section06;

public class ProxyImage implements Image{
    private final String path;
    private RealImage realImage;

    public ProxyImage(String path) {
        this.path = path;
    }

    @Override
    public void draw() {
        if (realImage == null) {
            realImage = new RealImage(path);
        }
        realImage.draw();
    }
}
