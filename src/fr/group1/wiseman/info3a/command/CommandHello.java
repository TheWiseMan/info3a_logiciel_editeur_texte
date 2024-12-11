package fr.group1.wiseman.info3a.command;
import fr.group1.wiseman.info3a.editor.Engine;

import java.util.logging.Logger;

public class CommandHello implements Command {
    private final Engine receiver;
    public CommandHello(Engine receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        Logger.getGlobal().info("Hello World !");
        this.receiver.getBufferContents();
    }
}
