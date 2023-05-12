package org.server.commands;

import org.server.ServerStuff.Comandable;
import org.server.ServerStuff.CommandResult;
import org.server.ServerStuff.MapWrapper;
import org.server.BasicPerson.Person;

public class Clear implements Comandable {
    static String name = "clear";
    private MapWrapper<Integer, Person> hashMap;
    public Clear (MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }

    public static String getName() {
        return name;
    }

    @Override
    public CommandResult execute(Object... id) {
        hashMap.clear();
        return new CommandResult("Collection has been cleared.", true);
    }


    @Override
    public String Description() {
        return "Clean the collection.\n" +
                "\"clear\"";
    }


}