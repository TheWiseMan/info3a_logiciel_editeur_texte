package fr.group1.wiseman.info3a.editor;

public class EngineImpl implements Engine {
    private final Buffer buffer;
    private final Selection selection;
    private String clipboard;
    public EngineImpl(String content) {
        buffer = new BufferImpl(content);
        selection = new SelectionImpl();
        clipboard = "";
    }

    @Override
    public Selection getSelection() {
        return selection;
    }

    public String getSelectedText() {
        Selection sel = this.getSelection();
        int selStart = sel.getBeginIndex();
        int selEnd = sel.getEndIndex();
        return buffer.getRange(selStart, selEnd);
    }

    @Override
    public String getBufferContents() {
        return buffer.getContent();
    }

    @Override
    public String getClipboardContents() {
        return clipboard;
    }

    @Override
    public void cutSelectedText() {

    }

    @Override
    public void copySelectionText() {
        this.clipboard = this.getSelectedText();
    }

    @Override
    public void pasteClipboard() {

    }

    @Override
    public void insert(String s) {

    }

    @Override
    public void delete() {

    }
}
