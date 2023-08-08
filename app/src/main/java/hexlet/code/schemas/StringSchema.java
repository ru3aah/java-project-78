package hexlet.code.schemas;

public class StringSchema extends CommonSchema {

    public  final StringSchema required() {
        addRequirement(s -> s instanceof String && !"".equals(s) && s != null);
        setRequiredOn();
        return this;
    }

    public final StringSchema minLenght(final int lenght) {
        addRequirement(s -> s.toString().length() >= lenght);
        return this;
    }

    public final StringSchema contains(final String substring) {
        addRequirement(s -> s.toString().contains(substring));
        return this;
    }
}
