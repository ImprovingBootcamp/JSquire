package framework.bases;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public abstract class MapKihonBase {
    protected abstract Map<String, String> createMapOfStringToString();

    protected abstract void addKeyAndValueToMap(Map<String, String> inputMap, String key, String value);

    protected abstract String getTheValueAtThisKey(Map<String, String> inputMap, String key);

    protected abstract boolean doesMapContainKey(Map<String, String> inputMap, String input);

    protected abstract void removeKeyFromMap(Map<String, String> inputMap, String key);

    protected abstract int countUniqueWordsInList(List<String> inputWords);

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

    @Test
    public void countUniqueWordsInListTest() {
        // Arrange
        List<String> words = List.of("austin", "austin", "texas", "aardvark",
                "flower", "allison", "is", "awesome", "awesome", "awesome");

        // Act
        int result = countUniqueWordsInList(words);

        // Assert
        assertEquals(words.stream().distinct().count(), result);
    }

}
