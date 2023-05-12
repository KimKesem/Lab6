package org.client.commands;

import org.client.ClientStuff.Comandable;
import org.client.ClientStuff.MapWrapper;
import org.client.BasicPerson.Person;


public class RemoveKey implements Comandable {

    static String name = "remove_key";
    private MapWrapper<Integer, Person> hashMap;
    public RemoveKey (MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }

    public static String getName() {
        return name;
    }


    @Override
    public String Description() {
        return "Deletes element by it's key.\n" +
                "\"remove_key\"";
    }


}