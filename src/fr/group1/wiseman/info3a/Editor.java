package fr.group1.wiseman.info3a;

import fr.group1.wiseman.info3a.command.CommandCut;
import fr.group1.wiseman.info3a.command.CommandExit;
import fr.group1.wiseman.info3a.command.CommandHello;
import fr.group1.wiseman.info3a.command.IHM;
import fr.group1.wiseman.info3a.editor.Engine;
import fr.group1.wiseman.info3a.editor.EngineImpl;

import java.util.logging.Logger;

public class Editor {
    private IHM invoker;
    private Engine receiver;

    public void run() {
        Logger.getGlobal().info("Starting...");
        this.invoker = new IHM();
        this.receiver = new EngineImpl("Hello world !");

        this.configureCommands();
        this.invoker.setReadStream(System.in);
        this.invoker.runInvokerLoop();
    }

    private void configureCommands() {
        this.invoker.addCommand("exit", new CommandExit(this.invoker));
        this.invoker.addCommand("cut", new CommandCut(this.receiver));
        this.invoker.addCommand("hello", new CommandHello(this.receiver));
    }
}
