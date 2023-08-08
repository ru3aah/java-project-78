package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ValidatorTest {

    private static final String STR_1 = "what does the fox say";
    private static final String STR_2 = "whatthe";
    private static final int LENGHTH_TRUE = 2;
    private static final int LENGTH_FALSE = 9;

    @Test
    public void testStringSchema() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));

        schema.required();
        assertTrue(schema.isValid(STR_1));
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));

        assertTrue(schema.contains("wh").isValid(STR_1));
        assertFalse(schema.contains("whatthe").isValid(STR_1));
        assertFalse(schema.isValid(STR_1));
        assertTrue(schema.minLenght(LENGHTH_TRUE).isValid(STR_2));
        assertFalse(schema.minLenght(LENGTH_FALSE).isValid(STR_2));
    }
}
