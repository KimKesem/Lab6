package org.client.commands;

import org.client.ClientStuff.Comandable;


public class History implements Comandable {
    static String name = "history";
    public static String getName(){
        return name;
    }

    @Override
    public String Description() {
        return "Shows user's last 12 commands.\n" +
                "\"history\"";
    }

}