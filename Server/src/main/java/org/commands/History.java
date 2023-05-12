package org.server.commands;
import org.server.ServerStuff.Comandable;
import org.server.ServerStuff.CommandResult;
import org.server.ServerStuff.Interaction;

import java.util.Arrays;
import java.util.Deque;

public class History implements Comandable {
    static String name = "history";
    public static String getName(){
        return name;
    }

    @Override
    public CommandResult execute(Object... id) {
        return new CommandResult(Arrays.toString(new Deque[]{Interaction.getDeque()}), true);
    }


    @Override
    public String Description() {
        return "Shows user's last 12 commands.\n" +
                "\"history\"";
    }

}