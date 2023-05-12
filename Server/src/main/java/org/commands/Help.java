package org.server.commands;
import org.server.ServerStuff.Comandable;
import org.server.ServerStuff.CommandManager;
import org.server.ServerStuff.CommandResult;
import org.server.ServerStuff.MapWrapper;
import org.server.BasicPerson.Person;


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
    public CommandResult execute(Object... o) throws Exception {

        CommandManager commandManager = new CommandManager(hashMap);
        commandManager.CommandsList();
        String descr = "";

        for (String key : commandManager.getCommands().keySet()) {
            descr += commandManager.getCommands().get(key).Description() + "\n\n";
        }
        return new CommandResult(descr, true);
    }
    @Override
    public String Description() {
        return "Shows all commands.\n" +
                "\"help\"";
    }

}