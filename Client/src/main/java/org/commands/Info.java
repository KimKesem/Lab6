package org.client.commands;

import org.client.ClientStuff.Comandable;
import org.client.ClientStuff.MapWrapper;
import org.client.BasicPerson.Person;

public class Info implements Comandable {
    static String name = "info";
    private MapWrapper<Integer, Person> hashMap;
    public Info (MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }




    public static String getName() {
        return name;
    }
    @Override
    public String Description() {
        return "Shows information about collection.\n" +
                "\"info\"";
    }
}