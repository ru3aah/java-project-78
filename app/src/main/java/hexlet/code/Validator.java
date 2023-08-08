package hexlet.code;

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
    public final hexlet.code.schemas.NumberSchema number() {
        return new hexlet.code.schemas.NumberSchema();
    }
}
