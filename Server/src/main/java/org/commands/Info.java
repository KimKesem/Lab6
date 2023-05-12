package org.server.commands;

import org.server.ServerStuff.Comandable;
import org.server.ServerStuff.MapWrapper;
import org.server.BasicPerson.Person;
import org.server.ServerStuff.CommandResult;

public class Info implements Comandable {
    static String name = "info";

    public static String getName() {
        return name;
    }
    private MapWrapper<Integer, Person> hashMap;
    public Info (MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public CommandResult execute(Object... o) {
        return new CommandResult("Collection type: " + hashMap.getClass() + "\n"
                + "Amount of Elements: " + hashMap.size()+ "\n", true);
    }


    @Override
    public String Description() {
        return "Shows information about collection.\n" +
                "\"info\"";
    }
}