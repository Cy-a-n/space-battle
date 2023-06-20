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
    private final Class<T> valueType;

    /**
     * Creates a new instance of {@link Nullable} with a value.
     * Use {@link #value(Object)} to instantiate this class instead.
     *
     * @param value The value to wrap
     */
    private Nullable(T value) {
        this.value = value;
        valueType = null;
    }

    /**
     * Creates a new instance of {@link Nullable} without a value.
     * Use {@link #noValue(Class)} to instantiate this class instead.
     *
     * @param valueType Because of type erasure, java would assume the generic type as {@link Object},
     *                  *             if the method had no parameters of type T. Pass the runtime type of the value like so {@code noValue(myType.class)}
     */
    private Nullable(Class<T> valueType) {
        this.value = null;
        this.valueType = valueType;
    }


    // TODO: Make value @NotNull

    /**
     * Creates a new Nullable object with the given value.
     *
     * @param value The value to wrap
     * @return A new Nullable object with the given value
     */
    public static <T> Nullable<T> value(T value) {
        if (
                value == null
        )
            throw new NullPointerException("Please don't pass a value of null to this method. Call 'Nullable.NoValue(Class<t> type)' instead");
        return new Nullable<>(value);
    }

    /**
     * Creates a new Nullable object with no value.
     *
     * @param type Because of type erasure, java would assume the generic type as {@link Object},
     *             if the method had no parameters of type T. Pass the runtime type of the value like so {@code noValue(myType.class)}
     * @return a new Nullable object with no value
     */
    public static <T> Nullable<T> noValue(Class<T> type) {

        return new Nullable<T>(type);
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

    /**
     * Returns the passed type of the value. This only works if value == null.
     *
     * @return The runtime class of the value.
     */
    Class getValueType() {
        return valueType;
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

        if (hasValue() == other.hasValue()) {
            // Compare values
            if (hasValue())
                return getValue().equals(other.getValue());

            // Both Result objects have a value of null, but of same generic type.
            if (valueType.equals(other.getValueType()))
                return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return hasValue() ? "Nullable.noValue()" : "Nullable.value(" + value + ")";
    }

}