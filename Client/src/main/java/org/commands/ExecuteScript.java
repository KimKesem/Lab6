package org.client.commands;

import org.client.ClientStuff.Comandable;
import org.client.ClientStuff.MapWrapper;
import org.client.BasicPerson.Person;


public class ExecuteScript implements Comandable {
    static String name = "execute_script_file";
    public static String getName() {
        return name;
    }    private MapWrapper<Integer, Person> hashMap;

    public ExecuteScript(MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }


    @Override
    public String Description() {
        return "Doing your script from certain file.\n" +
                "\"execute_script_file\"";
    }


}