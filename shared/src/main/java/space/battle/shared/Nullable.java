package space.battle.shared;

import java.util.NoSuchElementException;

/**
 * A Nullable class inspired by Rust's Option enum.
 * It represents an optional value, where a value can be present or not similar to null values.
 * This approach has some advantages over using null values,
 *
 * @param <T> the type of the value
 */
public class Nullable<T> {
    private final T value;

    private Nullable(T value) {
        this.value = value;
    }

    /**
     * Creates a new Nullable object with the given value.
     *
     * @param value the value to wrap
     * @return a new Nullable object with the given value
     */
    public static <T> Nullable<T> value(T value) {
        return new Nullable<>(value);
    }

    /**
     * Creates a new Nullable object with no value.
     *
     * @return a new Nullable object with no value
     */
    public static <T> Nullable<T> noValue() {
        return new Nullable<T>(null);
    }

    /**
     * Checks if the Nullable object has a value.
     *
     * @return true if the Nullable object has a value, false otherwise
     */
    public boolean hasValue() {
        return value != null;
    }

    /**
     * Retrieves the value of the Nullable object if present.
     *
     * @return the value of the Nullable object
     * @throws NoSuchElementException if there is no value present
     */
    public T getValue() {
        if (!hasValue()) {
            throw new NoSuchElementException("No value present. Be sure to check for a with 'Nullable.hasValue()' before calling this method, similar to null checks");
        }
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        // Check if obj is of same type
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // Cast obj
        Nullable<?> other = (Nullable<?>) obj;

        if (!hasValue() && !other.hasValue())
            return true;

        // Compare values
        return getValue().equals(other.getValue());

    }

    @Override
    public String toString() {
        return hasValue() ? "Nullable.noValue()" : "Nullable.value(" + value + ")";
    }

}