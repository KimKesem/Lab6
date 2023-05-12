package org.client.commands;

import org.client.ClientStuff.Comandable;
import org.client.ClientStuff.MapWrapper;
import org.client.BasicPerson.Person;

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
    public String Description() {
        return "Clean the collection.\n" +
                "\"clear\"";
    }


}