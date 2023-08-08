package hexlet.code;

import hexlet.code.schemas.StringSchema;

/**
 * Validator class check if data suits choosen validation scheme.
 */
public class Validator {

    /**
     * String schema contains methods to validate String data.
     * @return Boolean.
     */
    public final StringSchema string() {
        return new StringSchema();
    }
}
