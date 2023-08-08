package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

/**
 * Validator class check if data suits choosen validation scheme.
 */
public class Validator {

    /**
     * String schema contains methods to validate String data.
     * @return Schema
     */
    public final StringSchema string() {
        return new StringSchema();
    }
    /**
     * Number schema contains methods to validate Number data.
     * @return Schema
     */
    public final NumberSchema number() {
        return new NumberSchema();
    }
    /**
     * Map schema contains methods to work with Map.
     * @return Schema
     */
    public final MapSchema map() {
        return new MapSchema();
    }
}
