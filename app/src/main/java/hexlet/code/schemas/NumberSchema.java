package hexlet.code.schemas;

public class NumberSchema extends CommonSchema {
    /**
     * null is not allowed.
     * @return Boolean
     */
    public final NumberSchema required() {
        addRequirement(num -> num instanceof Integer);
        setRequiredOn();
        return this;
    }

    /**
     * checks if Number is positive.
     * @return Boolean
     */
    public final NumberSchema positive() {
        addRequirement(num -> num instanceof Integer && Integer
                .parseInt(num.toString()) > 0);
        return this;
    }

    /**
     * checks if Number is in between max & min including edges.
     * @param min int
     * @param max int
     * @return Boolean
     */
    public final NumberSchema range(final int min, final int max) {
        addRequirement(num -> num instanceof Integer && min <= Integer
                .parseInt(num.toString())
                && Integer.parseInt(num.toString()) <= max);
        return this;
    }
}