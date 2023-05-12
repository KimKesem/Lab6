package org.server.commands;
import org.server.ServerStuff.Comandable;
import org.server.ServerStuff.CommandResult;
import org.server.ServerStuff.IntArgument;
import org.server.ServerStuff.MapWrapper;
import org.server.BasicPerson.Person;

import java.util.Arrays;

public class RemoveKey implements Comandable, IntArgument {

    static String name = "remove_key";
    private MapWrapper<Integer, Person> hashMap;
    public RemoveKey (MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }

    public static String getName() {
        return name;
    }

    @Override
    public CommandResult execute(Object... o) {
        int id = Integer.valueOf(Arrays.toString(o).replaceAll("]", "").substring(1));
        CommandResult commandResult;
        if (hashMap.get(id) != null) {
            hashMap.remove(id);
            commandResult = new CommandResult("Element = " + id + "has been deleted.", true);
        } else {
            commandResult = new CommandResult("Model = " + id + " does not exist", false);
        }
        return commandResult;

    }



    @Override
    public String Description() {
        return "Deletes element by it's key.\n" +
                "\"remove_key\"";
    }


}