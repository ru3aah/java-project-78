package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ValidatorTest {

    /**
     * test string.
     */
    private static final String STR_1 = "what does the fox say";
    /**
     * test string.
     */
    private static final String STR_2 = "whatthe";
    /**
     * min length to be suitable for test string.
     */
    private static final int LENGHTH_TRUE = 2;
    /**
     * min length which test string is not suitable for.
     */
    private static final int LENGTH_FALSE = 9;

    /**
     * Test for stringSchema.
     */
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
    /**
     * test for NumberScheme.
     */
    @Test
    public void testNumberSchema() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        final int  minNumber = 2;
        final int maxNumber = 17;

        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid("5"));
        assertTrue(schema.isValid(10));

        assertTrue(schema.positive().isValid(10));
        assertFalse(schema.isValid(-10));

        schema.range(minNumber, maxNumber);
        assertTrue(schema.isValid(2));
        assertTrue(schema.isValid(16));
        assertFalse(schema.isValid(19));
        assertFalse(schema.isValid(-5));
    }
}
