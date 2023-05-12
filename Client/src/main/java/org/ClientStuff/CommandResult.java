package org.client.ClientStuff;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CommandResult {
    private String message;
    private boolean ight;
    @JsonCreator
    public CommandResult(@JsonProperty("message")String message,@JsonProperty("isSuccess") boolean ight) {
        this.message = message;
        this.ight = ight;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIght() {
        return ight;
    }
}