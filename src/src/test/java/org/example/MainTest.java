package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void polybiusCipher() {
        assertAll(
                () -> assertEquals("23153131345234423114", Main.polybiusCipher("helloworld")),
                () -> assertEquals("535455", Main.polybiusCipher("xyz"))
        );
    }

    @Test
    void decryptPolybiusCipher() {
        assertAll(
                () -> assertEquals("helloworld", Main.decryptPolybiusCipher("23153131345234423114")),
                () -> assertEquals("xyz", Main.decryptPolybiusCipher("535455"))
        );
    }

    @Test
    void saveToFile() {
        assertAll(
                () -> assertEquals(true, Main.saveToFile("23153131345234423114")),
                () -> assertEquals(true, Main.saveToFile("535455"))
        );
    }

    @Test
    void readFromFile() {
        assertAll(
                () -> assertEquals("23153131345234423114", Main.readFromFile("23153131345234423114")),
                () -> assertEquals("535455", Main.readFromFile("535455"))
        );
    }
}