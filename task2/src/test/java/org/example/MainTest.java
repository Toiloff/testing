package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void countEntries() {
        assertAll(
                () -> assertEquals(2, Main.countEntries("абвгабвг", "аб")),
                () -> assertEquals(2, Main.countEntries("hhfdfg235dxhfc", "hf")),
                () -> assertEquals(1, Main.countEntries("привет", "привет")),
                () -> assertEquals(0, Main.countEntries("привет", "тевирп")),
                () -> assertEquals(0, Main.countEntries("@1", "@#@fdg№1")),
                () -> assertEquals(0, Main.countEntries("1", "11"))
        );
    }
}