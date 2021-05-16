package oop.section05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoratorTest {
    @Test
    void executeEveryDecorators() {
        byte[] byteArray = {0x48, 0x65, (byte)0x6C, (byte)0x6C, (byte)0x6f, 0x20, 0x57, (byte)0x6f, 0x72, (byte)0x6c, 0x64};
        FileOut delegate = new FileOutImpl();

        Decorator decoratorsZipToEncrypt = new ZipOut(new EncryptionOut(delegate));
        decoratorsZipToEncrypt.write(byteArray);

        Decorator decoratorsEncryptToZip = new EncryptionOut(new ZipOut(delegate));
        decoratorsEncryptToZip.write(byteArray);

        //assert decoratorsZipToEncrypt and decoratorsEncryptToZip result same
    }

}
