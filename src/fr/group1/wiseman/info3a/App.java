package fr.group1.wiseman.info3a;

import fr.group1.wiseman.info3a.command.*;
import fr.group1.wiseman.info3a.editor.Engine;
import fr.group1.wiseman.info3a.editor.EngineImpl;

import java.util.logging.Logger;

public class App {
    private IHM invoker;
    private Engine receiver;

    public void run() {
        Logger.getGlobal().info("Starting...");
        this.receiver = new EngineImpl("Hello world !");
        this.receiver.getSelection().setBeginIndex(4);
        this.receiver.getSelection().setEndIndex(7);
        this.invoker = new IHM(System.in, this.receiver);

        this.configureCommands();
        this.invoker.runInvokerLoop();
    }

    private void configureCommands() {
        this.invoker.addCommand("exit", new CommandExit(this.invoker));
        this.invoker.addCommand("copy", new CommandCopy(this.receiver));
        this.invoker.addCommand("paste", new CommandPaste(this.receiver));
        this.invoker.addCommand("select", new CommandSelect(this.receiver));
        this.invoker.addCommand("cut", new CommandCut(this.receiver));
        this.invoker.addCommand("hello", new CommandHello(this.receiver));
        this.invoker.addCommand("hist", new CommandViewHistory(this.receiver));
        this.invoker.addCommand("undo", new CommandUndo(this.receiver));
    }
}
