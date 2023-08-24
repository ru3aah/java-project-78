package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    /**
     * set requirement for obj to be instance of Integer.
     */
    public NumberSchema() {
        addRequirement(Integer.class::isInstance);
    }
    /**
     * null is not allowed.
     * @return Boolean
     */
    public final NumberSchema required() {
        setRequiredOn();
        return this;
    }

    /**
     * checks if Number is positive.
     * @return Boolean
     */
    public final NumberSchema positive() {
        addRequirement(num -> (int) num > 0);
        return this;
    }

    /**
     * checks if Number is in between max & min including edges.
     * @param min int
     * @param max int
     * @return Boolean
     */
    public final NumberSchema range(final int min, final int max) {
        addRequirement(num -> min <= (int) num
                && (int) num <= max);
        return this;
    }
}
