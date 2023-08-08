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
    /**
     * validates data inside Map.
     * @param map Map
     * @return MapSchema
     */
    public final MapSchema shape(final Map<String, CommonSchema> map) {
        addRequirement(newMap
                -> chekingMap((Map<String, CommonSchema>) newMap, map));
        return this;
    }

    private boolean chekingMap(final Map<String, CommonSchema> orig,
                               final Map<String, CommonSchema> shapedMap) {
        for (Map.Entry<String, CommonSchema> map : shapedMap.entrySet()) {
            String key = map.getKey();
            if (!map.getValue().isValid(orig.get(key))) {
                return false;
            }
        }
        return true;
    }
}
