package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void calc() {
        assertAll(
                () -> assertEquals("x1 = 2.0, x2 = 0.5", Main.calc(2, -5, 2)),
                () -> assertEquals("Уравнение не имеет действительных корней!", Main.calc(3, 2, 5)),
                () -> assertEquals("x1 = 4.0, x2 = 0.0", Main.calc(3, -12, 0)),
                () -> assertEquals("Это не квадратное уравнение (a = 0)", Main.calc(0, 0, 10)),
                () -> assertEquals("Это не квадратное уравнение (a = 0)", Main.calc(0, 0, 0)),
                () -> assertEquals("Это не квадратное уравнение (a = 0)", Main.calc(0, 5, 17)),
                () -> assertEquals("x1=x2=0.0", Main.calc(9, 0, 0))
        );
    }
}