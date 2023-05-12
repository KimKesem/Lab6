package org.client.commands;

import org.client.ClientStuff.Comandable;
import org.client.ClientStuff.MapWrapper;
import org.client.BasicPerson.Person;

public class RemoveLowerKey implements Comandable {
    static String name = "remove_lower_key";
    private MapWrapper<Integer, Person> hashMap;
    public RemoveLowerKey (MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }

    public static String getName() {
        return name;
    }


    @Override
    public String Description() {
        return "Deletes fro collection all keys that are lower than given.\n" +
                "\"remove_lower_key\"";
    }
}