package framework.bases;

import framework.Item;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class StreamsKihonBase {
    private List<Item> items = createItems();

    protected abstract List<String> getTheNamesOfAllItems(List<Item> items);
    protected abstract List<Item> sortItemsAlphabeticallyBasedOnName(List<Item> items);
    protected abstract List<Item> sortOnCostFromLestToMostExpensiveAllItemsThatCostLessThanOrEqualToMyMonies(List<Item> items, int monies);
    protected abstract Item getTheItemWithTheMostCost(List<Item> items);
    protected abstract int getTheAverageCostRoundedDown(List<Item> items);
    protected abstract void addAllItemsToMyMapWIthKetNameAndValueOfCost(List<Item> items, Map<String, Integer> myMap);


    @Test
    void getTheNamesOfAllItems() {
        List<String> expectedNames = new ArrayList<>();
        for (Item i : items) {
            expectedNames.add(i.getName());
        }
        List<String> result = getTheNamesOfAllItems(items);
        assertEquals(expectedNames, result);
    }

    @Test
    void sortItemsAlphabeticallyBasedOnName() {
        List<Item> expectedItems = new ArrayList<>(items);
        expectedItems.sort(Comparator.comparing(Item::getName));
        List<Item> result = sortItemsAlphabeticallyBasedOnName(items);
        assertEquals(expectedItems, result);
    }

    @Test
    void sortOnCostFromLestToMostExpensiveAllItemsThatCostLessThanOrEqualToMyMonies() {
        List<Item> expectedItems = new ArrayList<>();
        expectedItems.add(items.get(6));
        expectedItems.add(items.get(7));
        expectedItems.add(items.get(0));
        expectedItems.add(items.get(2));
        List<Item> result = sortOnCostFromLestToMostExpensiveAllItemsThatCostLessThanOrEqualToMyMonies(items, 666);
        assertEquals(expectedItems, result);
    }

    @Test
    void getTheItemWithTheMostCost() {
        Item result = getTheItemWithTheMostCost(items);
        assertEquals(items.get(5), result);
    }

    @Test
    void getTheAverageCostRoundedDown() {
        int expectedAverage = 0;
        for (Item i : items) {
            expectedAverage += i.getCost();
        }
        expectedAverage = expectedAverage / items.size();
        int result = getTheAverageCostRoundedDown(items);
        assertEquals(expectedAverage, result);
    }

    @Test
    void addAllItemsToMyMapWIthKetNameAndValueOfCost() {
        Map<String, Integer> expectedMap = new HashMap<>();
        for (Item i : items) {
            expectedMap.put(i.getName(), i.getCost());
        }
        Map<String, Integer> myMap = new HashMap<>();
        addAllItemsToMyMapWIthKetNameAndValueOfCost(items, myMap);
        assertEquals(expectedMap, myMap);
    }

    private List<Item> createItems() {
        List<Item> i = new ArrayList<>();
        i.add(new Item("Phone", "Portable device for contacting peeps", 50));
        i.add(new Item("Smart Phone", "Portable device for contacting peeps and getting info", 700));
        i.add(new Item("Necronomicon", "Book of the dead, evil lies within", 666));
        i.add(new Item("Master Sword", "Ancient sword of light destined to vanquish the darkness", 999));
        i.add(new Item("Battle Riffle", "Primary mid range riffle of the UNSC", 1234));
        i.add(new Item("Mjolnir Mark 5", "UNSC Power Armor for Spartan Soldiers", 100100700));
        i.add(new Item("The One Ring", "A mysterious golden ring that is the master of all others", 0));
        i.add(new Item("stick", "A small dead branch", 1));
        return i;
    }
}
