package oop.section05;

abstract public class Decorator implements FileOut {
    private FileOut delegate; //위임 대상

    public Decorator(FileOut delegate) {
        this.delegate = delegate;
    }

    public void doDelegate(byte[] data) {
        delegate.write(data);
    }
}
