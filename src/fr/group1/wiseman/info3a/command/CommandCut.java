package fr.group1.wiseman.info3a.command;

import fr.group1.wiseman.info3a.editor.Engine;

public class CommandCut implements Command {
    public final Engine receiver;
    public CommandCut(Engine receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        this.receiver.cutSelectedText();
    }
}
