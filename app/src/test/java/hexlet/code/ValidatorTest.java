package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
        assertTrue(schema.minLength(LENGHTH_TRUE).isValid(STR_2));
        assertFalse(schema.minLength(LENGTH_FALSE).isValid(STR_2));
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
    /**
     * test for Map schema.
     */
    @Test
    public void testMapSchema() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));
        java.util.Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));

        schema.sizeof(2);
        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }
    /**
     * Shape test.
     */
    @Test
    public void testShape() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        assertTrue(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertTrue(schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertFalse(schema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        assertFalse(schema.isValid(human4));
    }
}

