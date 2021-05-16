package oop.section05;

public class EncryptionOut extends Decorator{
    public EncryptionOut(FileOut delegate) {
        super(delegate);
    }

    @Override
    public void write(byte[] data) {
        String newString = new String(data) + " > " + this.getClass().getName();

        System.out.println(newString);

        super.doDelegate(newString.getBytes());
    }
}
