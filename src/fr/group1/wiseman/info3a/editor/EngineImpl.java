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
        this.copySelectionText();
        this.delete();
    }

    @Override
    public void copySelectionText() {
        this.clipboard = this.getSelectedText();
    }

    @Override
    public void pasteClipboard() {
        this.insert(this.clipboard);
    }

    @Override
    public void insert(String s) {
        Selection sel = this.getSelection();
        int selStart = sel.getBeginIndex();
        int selEnd = sel.getEndIndex();
        this.buffer.setRange(selStart, selEnd, s);
        sel.setEndIndex(selStart+s.length());
    }

    @Override
    public void delete() {
        Selection sel = this.getSelection();
        int selStart = sel.getBeginIndex();
        int selEnd = sel.getEndIndex();
        this.buffer.setRange(selStart, selEnd, "");
        sel.setEndIndex(selStart);
    }
}
