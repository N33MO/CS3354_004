package module6.myclass;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MyClassTest {
    @Test
    void testMultiply_returnsZeroWhenSecondOperandIsZero() {
        MyClass tester = new MyClass();

        assertEquals(0, tester.multiply(10, 0), "10 x 0 must be 0");
    }

    @Test
    void testMultiply_returnsZeroWhenFirstOperandIsZero() {
        MyClass tester = new MyClass();

        assertEquals(0, tester.multiply(0, 10), "0 x 10 must be 0");
    }

    @Test
    void testMultiply_returnsZeroWhenBothOperandsAreZero() {
        MyClass tester = new MyClass();

        assertEquals(0, tester.multiply(0, 0), "0 x 0 must be 0");
    }
}
