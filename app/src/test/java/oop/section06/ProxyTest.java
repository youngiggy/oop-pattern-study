package oop.section06;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProxyTest {
    @Test
    void listUiTest() {
        List<Image> images = new ArrayList<>();
        images.add(new ProxyImage("path1"));
        images.add(new ProxyImage("path2"));
        images.add(new ProxyImage("path3"));

        for (Image image : images) {
            image.draw();
        }
    }

}
