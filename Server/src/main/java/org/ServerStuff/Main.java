package org.server.ServerStuff;

import org.server.BasicPerson.Person;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {

        MapWrapper<Integer, Person> hashMap = new MapWrapper<>(HashMap.class);
        CollectionManager collectionManager = new CollectionManager<>(hashMap);
        try {

            MapWrapper<Integer, Person> pCollection = collectionManager.deserialize(new File("C:\\Users\\User\\IdeaProjects\\KOTLIN\\Lab5\\src\\some_data.json"));
            CommandManager commandManager = new CommandManager(pCollection);
            commandManager.CommandsList();
            Interaction.interactiveModeOn(commandManager.getCommands(), pCollection);
        } catch (FileNotFoundException e) {
            System.out.println("Damn.");
        }
    }
}