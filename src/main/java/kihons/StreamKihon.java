package kihons;

import framework.Item;
import framework.bases.StreamsKihonBase;
import framework.exceptions.NotImplementedYetException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamKihon extends StreamsKihonBase {

    @Override
    protected List<String> getTheNamesOfAllItems(List<Item> items) {
        throw new NotImplementedYetException();
    }

    @Override
    protected List<Item> sortItemsAlphabeticallyBasedOnName(List<Item> items) {
        throw new NotImplementedYetException();
    }

    @Override
    protected List<Item> sortOnCostFromLestToMostExpensiveAllItemsThatCostLessThanOrEqualToMyMonies(List<Item> items, int monies) {
        return items.stream().sorted(Comparator.comparing(Item::getCost)).filter(i -> i.getCost() <= monies).collect(Collectors.toList());
    }

    @Override
    protected Item getTheItemWithTheMostCost(List<Item> items) {
        return items.stream().sorted(Comparator.comparing(Item::getCost).reversed()).findFirst().get();
    }

    @Override
    protected int getTheAverageCostRoundedDown(List<Item> items) {
        return items.stream().map(i -> i.getCost()).reduce(0, (ans, cur) -> ans += cur)/items.size();
    }

    @Override
    protected void addAllItemsToMyMapWIthKetNameAndValueOfCost(List<Item> items, Map<String, Integer> myMap) {
        items.stream().forEach(i -> myMap.put(i.getName(), i.getCost()));
    }
}
