package org.client.ClientStuff;


public class Main {
    public static void main(String[] args){

        CommandManager commandManager = new CommandManager();
        commandManager.CommandsList();
        Interaction.interactiveModeOn(commandManager.getCommands());

    }
}