package org.client.commands;

import org.client.ClientStuff.Comandable;
import org.client.ClientStuff.MapWrapper;
import org.client.BasicPerson.Person;


public class ReplaceIfGreater implements Comandable {
    static String name = "replace_if_greater";
    private MapWrapper<Integer, Person> hashMap;
    public ReplaceIfGreater (MapWrapper<Integer, Person> hashMap) throws Exception {
        this.hashMap = hashMap;
    }

    @Override
    public String Description() {
        return "Replace value by the key if its lower than the key.\n" +
                "\"replace_if_greater\"";
    }
    public static String getName() {
        return name;
    }
}