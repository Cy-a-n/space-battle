package space.battle.shared;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NullableTest {

    // TODO: Implement further tests
    @Test
    void value() {
    }

    @Test
    void noValue() {
    }

    @Test
    void hasValue() {
    }

    @Test
    void getValue() {
    }

    @Test
    void testEquals() {
        System.out.println(Nullable.value("test").equals(Nullable.value("test")));
        System.out.println(Nullable.value(15).equals(Nullable.value("test")));
        System.out.println(Nullable.noValue().equals(Nullable.noValue()));
    }

    @Test
    void testToString() {
    }
}