package org.server.commands;
import org.server.ServerStuff.Comandable;
import org.server.ServerStuff.CommandResult;
import org.server.ServerStuff.MapWrapper;
import org.server.BasicPerson.Person;

public class SumOfHeights implements Comandable {
    static String name = "sum_of_heights";
    private MapWrapper<Integer, Person> hashMap;
    public SumOfHeights(MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }

    public static String getName() {
        return name;
    }

    @Override
    public CommandResult execute(Object... o) {
        Double sum = 0.0;
        for (Person value : hashMap.values()) {
            sum += value.getHeight();
        }
        return new CommandResult("Current height sum of all elements = " + sum, true);
    }

    @Override
    public String Description() {
        return "Shows height  sum of all elements .\n" +
                "sum_of_heights";
    }
}