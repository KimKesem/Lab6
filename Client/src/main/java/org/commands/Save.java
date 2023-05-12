package org.client.commands;

import org.client.ClientStuff.Comandable;
import org.client.ClientStuff.MapWrapper;
import org.client.BasicPerson.Person;


public class Save implements Comandable {
    static String name = "save";
    private MapWrapper<Integer, Person> hashMap;
    public Save (MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }

    public static String getName() {
        return name;
    }

    @Override
    public String Description() {
        return "Save collection into a file.\n" +
                "\"save\"";
    }

}