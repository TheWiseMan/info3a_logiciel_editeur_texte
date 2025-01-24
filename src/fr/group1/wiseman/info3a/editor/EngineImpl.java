package fr.group1.wiseman.info3a.editor;

public class EngineImpl implements Engine {
    private final Buffer buffer;
    private final Selection selection;
    private String clipboard;
    private final VersionManager versionMgr;
    public EngineImpl(String content) {
        this.buffer = new BufferImpl(content);
        this.selection = new SelectionImpl();
        this.versionMgr = new VersionManagerImpl();
        this.clipboard = "";
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
        this.versionMgr.addOperation(new AtomicOperationImpl(this.buffer, selStart, selEnd, s));
        this.buffer.setRange(selStart, selEnd, s);
        sel.setEndIndex(selStart+s.length());
    }

    @Override
    public void delete() {
        /*Selection sel = this.getSelection();
        int selStart = sel.getBeginIndex();
        int selEnd = sel.getEndIndex();
        this.versionMgr.addOperation(new AtomicOperationImpl(this.buffer, selStart, selEnd, ""));
        this.buffer.setRange(selStart, selEnd, "");
        sel.setEndIndex(selStart);*/
        this.insert("");
    }

    @Override
    public void seeHistory() {
        this.versionMgr.debugHistory();
    }

    @Override
    public void undo() {
        this.versionMgr.undo(this.buffer);
    }
}
