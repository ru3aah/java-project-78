package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    /**
     * set requirement for obj to be instance of Map.
     */
    public MapSchema() {
        addRequirement(map -> map instanceof Map<?, ?>);
    }
    /**
     * Prohibits null value.
     * @return Boolean
     */
    public final MapSchema required() {
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
    public final MapSchema shape(final Map<String, BaseSchema> map) {
        addRequirement(newMap
                -> chekingMap((Map<String, BaseSchema>) newMap, map));
        return this;
    }
    /**
     * checks data inside the Map.
     * @param orig original map
     * @param shapedMap shaped map
     * @return Boolean
     */
    private boolean chekingMap(final Map<String, BaseSchema> orig,
                               final Map<String, BaseSchema> shapedMap) {
        for (Map.Entry<String, BaseSchema> map : shapedMap.entrySet()) {
            String key = map.getKey();
            if (!map.getValue().isValid(orig.get(key))) {
                return false;
            }
        }
        return true;
    }
}
