package org.client.commands;

import org.client.ClientStuff.Comandable;


public class Exit implements Comandable {
    static String name = "exit";

    public static String getName() {
        return name;
    }

    @Override
    public String Description() {
        return "Ends work of program.\n" +
                "\"exit\"";
    }
}