package org.server.commands;
import org.server.ServerStuff.CollectionManager;
import org.server.ServerStuff.Comandable;
import org.server.ServerStuff.CommandResult;
import org.server.ServerStuff.MapWrapper;
import org.server.BasicPerson.Person;

import java.io.File;
import java.io.IOException;

public class Save implements Comandable {
    static String name = "save";
    private MapWrapper<Integer, Person> hashMap;
    public Save (MapWrapper<Integer, Person> hashMap) {
        this.hashMap = hashMap;
    }

    public static String getName() {
        return name;
    }

    @Override
    public CommandResult execute(Object... o) throws IOException {
        CollectionManager collectionManager = new CollectionManager<>(hashMap);
        collectionManager.serialize(new File("C:\\Users\\User\\IdeaProjects\\KOTLIN\\Lab5\\src\\output_file.json"));
        return new CommandResult("Collection has been saved!", true);
    }
    @Override
    public String Description() {
        return "Save collection into a file.\n" +
                "\"save\"";
    }
}