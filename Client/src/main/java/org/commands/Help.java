package org.client.commands;
import org.client.ClientStuff.Comandable;
import org.client.ClientStuff.MapWrapper;
import org.client.BasicPerson.Person;


public class Help implements Comandable {
    static String name = "help";
    private MapWrapper<Integer, Person> hashMap;
    public Help (MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }

    public static String getName() {
        return name;
    }

    @Override
    public String Description() {
        return "Shows all commands.\n" +
                "\"help\"";
    }

}