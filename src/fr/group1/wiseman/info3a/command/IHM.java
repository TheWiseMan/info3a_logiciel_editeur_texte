package fr.group1.wiseman.info3a.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class IHM implements CommandInvoker {
    private final Map<String, Command> commands = new HashMap<>();
    private boolean stopLoop = false;
    private BufferedReader bufferedReader;

    @Override
    public void runInvokerLoop() {
        while (!stopLoop) {
            String userInput = null;
            try {
                userInput = this.readUserInput();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (userInput == null) {
                stopLoop = true;
                break;
            }
            Command cmdToExecute = commands.get(userInput);
            if (cmdToExecute != null) {
                cmdToExecute.execute();
            }
        }
    }

    @Override
    public void stopLoop() {
        stopLoop = true;
    }

    private String readUserInput() throws IOException {
        return bufferedReader.readLine();
    }

    /**
     * Registers a new keyword/command pair
     *
     * @param keyword a non-null String
     * @param cmd     a non-null Command reference
     * @throws java.lang.IllegalArgumentException for null parameters
     */
    @Override
    public void addCommand(String keyword, Command cmd) {
        if ((keyword == null) || (cmd == null)) {
            throw new IllegalArgumentException("null parameter");
        }
        commands.put(keyword, cmd);
    }

    @Override
    public void setReadStream(InputStream inputStream) {
        if (inputStream == null) {
            throw new IllegalArgumentException("null inputStream");
        }
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }
}
