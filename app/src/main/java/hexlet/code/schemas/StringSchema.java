package hexlet.code.schemas;

public class StringSchema extends CommonSchema {

    /**
     * Empty or null is not allowed.
     * @return Boolean
     */
    public  final StringSchema required() {
        addRequirement(s -> s instanceof String && !"".equals(s));
        setRequiredOn();
        return this;
    }

    /**
     * Checks if String is >= specified minimal length.
     * @param lenght - minimal allowed length
     * @return Boolean
     */
    public final StringSchema minLenght(final int lenght) {
        addRequirement(s -> s.toString().length() >= lenght);
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
