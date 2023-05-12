package org.server.commands;

import org.server.ServerStuff.Comandable;
import org.server.ServerStuff.CommandResult;
import org.server.ServerStuff.MapWrapper;
import org.server.BasicPerson.Person;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ChangeOrderOfHeights implements Comandable {
    static String name = "change_order_of_heights";
    private MapWrapper<Integer, Person> hashMap;

    public ChangeOrderOfHeights(MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }

    public static String getName() {
        return name;
    }


    @Override
    public CommandResult execute(Object... o) {
        HashMap<Integer, Double> unsortedList = new HashMap<>();
        for (int key : hashMap.keySet()) {
            unsortedList.put(key, hashMap.get(key).getHeight());
        }

        Map<Integer, Double> sortedMap = unsortedList.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> (int) -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));

        return new CommandResult(sortedMap.entrySet().toString(), true);
    }


    @Override
    public String Description() {
        return "Shows new order of heights with descending order.\n" +
                "\"change_order_of_heights\"";
    }
}