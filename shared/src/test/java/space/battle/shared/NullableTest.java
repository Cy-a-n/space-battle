package space.battle.shared;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NullableTest {

    // TODO: Implement further tests
    @Test
    void value() {
        assertDoesNotThrow(() -> Nullable.value("Normal calling of method"));
        assertThrows(NullPointerException.class, () -> Nullable.value(null));

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
    void getClassOfValue() {
    }

    @Test
    void testEquals() {
        assertFalse(Nullable.value("Test null").equals(null));
        assertFalse(Nullable.noValue(Object.class).equals(null));

        assertFalse(Nullable.value("Test different type").equals("Test different type"));
        assertFalse(Nullable.noValue(String.class).equals("Test different type"));

        assertFalse(Nullable.value("Only one nullable has value").equals(Nullable.noValue(String.class)));
        assertFalse(Nullable.noValue(String.class).equals(Nullable.value("Only one nullable has value")));

        assertFalse(Nullable.value("Different types of the values").equals(Nullable.value(0)));
        assertFalse(Nullable.noValue(String.class).equals(Nullable.noValue(Integer.class)));

        assertFalse(Nullable.value("Different ").equals(Nullable.value("values")));
        // Doesn't pass, probably because of new ArrayList<String>(1).equals(new ArrayList<String>(2)) = true, which really isn't my fault.
        // assertFalse(Nullable.value(new ArrayList<String>(1)).equals(Nullable.value(new ArrayList<String>(2))));

        assertTrue(Nullable.value("Same value").equals(Nullable.value("Same Value")));
    }

    @Test
    void testToString() {
    }
}