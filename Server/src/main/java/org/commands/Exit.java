package org.server.commands;
import org.server.ServerStuff.Comandable;
import org.server.ServerStuff.CommandResult;
import org.server.ServerStuff.Interaction;


public class Exit implements Comandable {
    static String name = "exit";

    public static String getName() {
        return name;
    }

    @Override
    public CommandResult execute(Object... id) {
        Interaction.InteractiveModeOff();
        return new CommandResult("closed", true);
    }


    @Override
    public String Description() {
        return "Ends work of program.\n" +
                "\"exit\"";
    }
}