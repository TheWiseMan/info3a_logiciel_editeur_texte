package fr.group1.wiseman.info3a.command;

import fr.group1.wiseman.info3a.editor.Engine;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


public class IHM implements CommandInvoker {
    private final Map<String, Command> commands = new HashMap<>();
    private boolean stopLoop = false;
    private BufferedReader bufferedReader;
    private final Engine engine;

    public IHM(InputStream input, Engine engine) {
        this.engine = engine;
        if (input == null) {
            throw new IllegalArgumentException("null inputStream");
        }
        this.bufferedReader = new BufferedReader(new InputStreamReader(input));
    }

    @Override
    public void runInvokerLoop() {
        while (!stopLoop) {
            String userInput = null;
            try {
                userInput = this.readUserInput();
            } catch (IOException e) {
                //e.printStackTrace();
            }
            if (userInput == null) {
                stopLoop = true;
                break;
            }
            Command cmdToExecute = commands.get(userInput);
            if (cmdToExecute != null) {
                cmdToExecute.execute();
                Logger.getGlobal().info("Buffer:" + this.engine.getBufferContents());
                Logger.getGlobal().info("Clipboard:" + this.engine.getClipboardContents());
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
