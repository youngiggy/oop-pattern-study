package oop.section05;

public class FileOutImpl implements FileOut{
    @Override
    public void write(byte[] data) {
        String newString = new String(data) + " > " + this.getClass().getName();

        System.out.println(newString);
    }
}
