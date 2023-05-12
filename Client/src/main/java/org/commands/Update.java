package org.client.commands;


import org.client.ClientStuff.Comandable;
import org.client.ClientStuff.MapWrapper;
import org.client.BasicPerson.Person;


public class Update implements Comandable {
    static String name = "update";
    private MapWrapper<Integer, Person> hashMap;

    public Update(MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }


    public static String getName() {
        return name;
    }

    @Override
    public String Description() {
        return "Update value of element in collection.\n" +
                "\"update {id}\"";
    }
}