package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    /**
     * Empty or null is not allowed.
     * @return Boolean
     */
    public  final StringSchema required() {
        addRequirement(s -> s instanceof String
                && s != null && !((String) s).isEmpty());
        setRequiredOn();
        return this;
    }

    /**
     * Checks if String is >= specified minimal length.
     * @param length - minimal allowed length
     * @return Boolean
     */
    public final StringSchema minLength(final int length) {
        addRequirement(s -> s.toString().length() >= length);
        return this;
    }

    /**
     * Checks if specified substring exist in the given String.
     * @param substring -  String
     * @return Boolean
     */
    public final StringSchema contains(final String substring) {
        addRequirement(s -> s.toString().contains(substring));
        return this;
    }
}
