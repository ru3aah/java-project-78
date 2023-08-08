package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends CommonSchema {
    /**
     * Prohibits null value.
     * @return Boolean
     */
    public final MapSchema required() {
        addRequirement(map -> map instanceof java.util.Map<?, ?>);
        setRequiredOn();
        return this;
    }
    /**
     * requires Map of given size.
     * @param givenSize givenSize
     * @return Boolean
     */
    public final MapSchema sizeof(final int givenSize) {
        addRequirement(map -> map instanceof Map
                && ((Map<?, ?>) map).size() == givenSize);
        return this;
    }
}
