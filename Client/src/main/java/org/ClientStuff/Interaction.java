package org.client.ClientStuff;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.client.commands.Exit;

import java.net.*;
import java.util.*;

public class Interaction {
    static boolean mode = true;
    static DatagramSocket clientSocket;

    static {
        try {
            clientSocket = new DatagramSocket();
            clientSocket.setSoTimeout(5000);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    static InetAddress IPAddress;

    static {
        try {
            IPAddress = InetAddress.getByName("localhost");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public Interaction() {
    }


    public static void interactiveModeOn(ArrayList<String> commands) {
        Scanner sc = new Scanner(System.in);
        ConsoleWriter consoleWriter = new ConsoleWriter();


        while (mode) {
            consoleWriter.printToConsole("Enter command:");
            String input = sc.nextLine();
            String[] ArrayOfInput = input.split(" ");
            runCommand(commands, ArrayOfInput);
        }
        sc.close();
    }

    public static void InteractiveModeOff() {
        mode = false;
        clientSocket.close();
    }


    public static void runCommand(ArrayList<String> commands, String[] arrayOfInput) {
        ConsoleWriter consoleWriter = new ConsoleWriter();
        try {
            Request input;
            if (arrayOfInput[0].equals(Exit.getName())) {
                InteractiveModeOff();
            }
            CommandManager commandManager = new CommandManager();
            commandManager.CommandsList();

            if (arrayOfInput.length > 1) {
                if (commandManager.getCommandsExtraData().contains(arrayOfInput[0])) {
                    DataStore dataStore = new DataStore();
                    dataStore.putData();
                    arrayOfInput[1] += " " + dataStore.getName() + " " + dataStore.getValue();
                } else if (commandManager.getCommandsExtraModel().contains(arrayOfInput[0])) {
                    ClientThing clientThing = new ClientThing();
                    clientThing.putData();
                    arrayOfInput[1] += " " + clientThing.getName() + " " + clientThing.getX()
                            + " " + clientThing.getY() + " " + clientThing.getHeight()
                            + " " + clientThing.getWeight()
                            + " " + clientThing.getHairColor();
                }
                try {
                    int id = Integer.parseInt(arrayOfInput[1]);
                    input = new Request<>(arrayOfInput[0], id);

                } catch (NumberFormatException e) {
                    input = new Request<>(arrayOfInput[0], arrayOfInput[1]);
                }
            } else {
                if (commandManager.getCommandsExtraModel().contains(arrayOfInput[0])) {
                    ClientThing clientThing = new ClientThing();
                    clientThing.putData();
                    String[] extraInput = new String[10];
                    extraInput[0] = clientThing.getName() + " " + clientThing.getX()
                            + " " + clientThing.getY() + " " + clientThing.getHeight()
                            + " " + clientThing.getWeight() + " "
                            + " " + clientThing.getHairColor();
                    input = new Request(arrayOfInput[0], extraInput[0]);
                } else {
                    input = new Request(arrayOfInput[0]);
                }
            }

            if (commands.contains(input.getCommand())) {

                ObjectMapper objectMapper = new ObjectMapper();
                String inputString = objectMapper.writeValueAsString(input);
                byte[] sendData = inputString.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 8081);
                clientSocket.send(sendPacket);

                byte[] receiveData = new byte[1048576];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                while (true){
                    try {
                        clientSocket.receive(receivePacket);
                        String response = new String(receivePacket.getData(), 0, receivePacket.getLength()).trim();
                        CommandResult commandResult = objectMapper.readValue(response, CommandResult.class);
                        consoleWriter.printToConsole("Server response: \n" + commandResult.getMessage());
                        break;
                    } catch (SocketTimeoutException e) {
                        consoleWriter.printToConsole("Troubles with connection.");
                        clientSocket = new DatagramSocket();
                        clientSocket.setSoTimeout(5000);
                        clientSocket.send(sendPacket);
                        receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    }
                }



            } else {
                consoleWriter.printToConsole("You might enter command wrong .\n" +
                        "Use \"help\".");
            }
        } catch (SocketException e) {
            consoleWriter.printToConsole("Socket is closed.");
        } catch (Exception e) {
            consoleWriter.printToConsole(arrayOfInput[0]);
            consoleWriter.printToConsole("You might enter command wrong .\n" +
                    "Use \"help\".");
            consoleWriter.printToConsole(e.getMessage());
        }
    }
}