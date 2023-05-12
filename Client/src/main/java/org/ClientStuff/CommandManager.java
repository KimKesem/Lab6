package org.client.ClientStuff;

import org.client.commands.*;
import org.client.commands.*;

import java.util.ArrayList;

public class CommandManager {
    private ArrayList<String> commandsMap = new ArrayList<>();
    private ArrayList<String> commandsExtraData = new ArrayList<>();
    private ArrayList<String> commandsExtraModel = new ArrayList<>();

    public CommandManager() {}


    public void CommandsList(){
        commandsMap.add(Clear.getName());
        commandsMap.add(RemoveKey.getName());
        commandsMap.add(Show.getName());
        commandsMap.add(Help.getName());
        commandsMap.add(RemoveLowerKey.getName());
        commandsMap.add(SumOfHeights.getName());
        commandsMap.add(ChangeOrderOfHeights.getName());
        commandsMap.add(Exit.getName());
        commandsMap.add(Update.getName());
        commandsExtraModel.add(Update.getName());
        commandsMap.add(Add.getName());
        commandsExtraModel.add(Add.getName());
        commandsMap.add(PrintWeight.getName());
        commandsMap.add(ReplaceIfGreater.getName());
        commandsExtraData.add(ReplaceIfGreater.getName());
        commandsMap.add(History.getName());
        commandsMap.add(Info.getName());
        commandsMap.add(Save.getName());
        commandsMap.add(ExecuteScript.getName());
    }

    public void removeExecuteScript() {
        commandsMap.remove(ExecuteScript.getName());
        this.commandsMap = commandsMap;
    }

    public ArrayList<String> getCommands(){
        return commandsMap;
    }
    public ArrayList<String> getCommandsExtraData() {
        return commandsExtraData;
    }

    public ArrayList<String> getCommandsExtraModel() {
        return commandsExtraModel;
    }

}