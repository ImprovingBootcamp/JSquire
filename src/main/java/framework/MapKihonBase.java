package framework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public abstract class MapKihonBase {
    protected abstract Map<String, String> createMapOfStringToString();
    protected abstract void addKeyAndValueToMap(Map<String, String> inputMap, String key, String value);
    protected abstract String getTheValueAtThisKey(Map<String, String> inputMap, String key);
    protected abstract boolean doesMapContainKey(Map<String, String> inputMap, String input);
    protected abstract void removeKeyFromMap(Map<String, String> inputMap, String key);

    @Test
    public void createMapOfStringToStringTest() {
        // Arrange

        // Act
        Map<String, String> newMap = createMapOfStringToString();

        // Assert
        assertNotNull(newMap);
    }

    @Test
    public void putKeyAndValueToMapTest() {
        // Arrange
        Map<String, String> map = new HashMap<>();

        // Act
        addKeyAndValueToMap(map, "austin", "hello");

        // Assert
        assertEquals("hello", map.getOrDefault("austin", ""));

    }


    @Test
    public void getTheValueAtThisKeyTest() {
        // Arrange
        Map<String, String> map = Map.of("improving", "Improving Bootcamp");

        // Act
        String value = getTheValueAtThisKey(map, "improving");


        // Assert
        assertEquals("Improving Bootcamp", value);
    }

    @Test
    public void doesMapContainKeyTest() {
        // Arrange
        Map<String, String> map = Map.of("improving", "Improving Bootcamp");

        // Act
        boolean result = doesMapContainKey(map, "hello");

        // Assert
        assertFalse(result);
    }

    @Test
    public void removeKeyFromMapTest() {
        // Arrange
        Map<String, String> map = new HashMap<>();
        map.put("improving", "Improving Bootcamp");

        // Act
        removeKeyFromMap(map, "improving");

        // Assert
        assertTrue(map.isEmpty());
    }

}
