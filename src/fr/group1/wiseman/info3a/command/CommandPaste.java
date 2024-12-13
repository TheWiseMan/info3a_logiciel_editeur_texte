package fr.group1.wiseman.info3a.command;

import fr.group1.wiseman.info3a.editor.Engine;

public class CommandPaste implements Command {
    Engine receiver;
    public CommandPaste(Engine receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        this.receiver.pasteClipboard();
    }
}
