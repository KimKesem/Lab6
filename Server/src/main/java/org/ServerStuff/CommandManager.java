package org.server.ServerStuff;

import org.server.commands.*;
import org.server.BasicPerson.Person;

import java.util.HashMap;

public class CommandManager {
    private HashMap<String, Comandable> commandsMap = new HashMap<>();
    private MapWrapper<Integer, Person> hashMap;
    public CommandManager (MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }


    public void CommandsList() throws Exception {
        commandsMap.put(Clear.getName(), new Clear(hashMap));
        commandsMap.put(RemoveKey.getName(), new RemoveKey(hashMap));
        commandsMap.put(Show.getName(), new Show(hashMap));
        commandsMap.put(Help.getName(), new Help(hashMap));
        commandsMap.put(RemoveLowerKey.getName(), new RemoveLowerKey(hashMap));
        commandsMap.put(SumOfHeights.getName(), new SumOfHeights(hashMap));
        commandsMap.put(ChangeOrderOfHeights.getName(), new ChangeOrderOfHeights(hashMap));
        commandsMap.put(Exit.getName(), new Exit());
        commandsMap.put(Update.getName(), new Update(hashMap));
        commandsMap.put(Add.getName(), new Add(hashMap));
        commandsMap.put(PrintWeight.getName(), new PrintWeight(hashMap));
        commandsMap.put(ReplaceIfGreater.getName(), new ReplaceIfGreater(hashMap));
        commandsMap.put(History.getName(), new History());
        commandsMap.put(Info.getName(), new Info(hashMap));
        commandsMap.put(Save.getName(), new Save(hashMap));
        commandsMap.put(ExecuteScript.getName(), new ExecuteScript(hashMap));
    }


    public HashMap<String, Comandable> getCommands(){
        return commandsMap;
    }


}