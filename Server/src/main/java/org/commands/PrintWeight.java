package org.server.commands;

import org.server.ServerStuff.Comandable;
import org.server.ServerStuff.CommandResult;
import org.server.ServerStuff.MapWrapper;
import org.server.BasicPerson.Person;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class PrintWeight implements Comandable {
    static String name = "print_unique_weight";
    private MapWrapper<Integer, Person> hashMap;
    public PrintWeight(MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }


    @Override
    public CommandResult execute(Object... o) {
        HashMap<Integer, Float> CapacityList = new HashMap<>();
        for (int key : hashMap.keySet()) {
            CapacityList.put(key, hashMap.get(key).getWeight());
        }

        Set<Float> capacityValues = new TreeSet<>(CapacityList.values());
        return new CommandResult(capacityValues.toString(), true);
    }



    @Override
    public String Description() {
        return "Prints unique values of weight field.\n" +
                "\"print_unique_weight\"";
    }

    public static String getName() {
        return name;
    }
}