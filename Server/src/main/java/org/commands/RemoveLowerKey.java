package org.server.commands;

import org.server.ServerStuff.Comandable;
import org.server.ServerStuff.CommandResult;
import org.server.ServerStuff.IntArgument;
import org.server.ServerStuff.MapWrapper;
import org.server.BasicPerson.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveLowerKey implements Comandable, IntArgument {
    static String name = "remove_lower_key";
    private MapWrapper<Integer, Person> hashMap;
    public RemoveLowerKey (MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }

    public static String getName() {
        return name;
    }

    @Override
    public CommandResult execute(Object... o){
        List<Integer> keysForRemoving = new ArrayList<>();
        String result = "";
        int id = Integer.valueOf(Arrays.toString(o).replaceAll("]", "").substring(1));
        for (int key : hashMap.keySet()) {
            if (key < id) {
                keysForRemoving.add(key);
            }
        }
        for (int key : keysForRemoving) {
            hashMap.remove(key);
            result += "From collection was deleted  = " + key + "\n";
        }
        return new CommandResult(result, true);
    }


    @Override
    public String Description() {
        return "Deletes fro collection all keys that are lower than given.\n" +
                "\"remove_lower_key\"";
    }
}