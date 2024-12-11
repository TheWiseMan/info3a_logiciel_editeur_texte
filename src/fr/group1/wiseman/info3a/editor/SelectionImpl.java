package fr.group1.wiseman.info3a.editor;

public class SelectionImpl implements Selection {
    private int start;
    private int end;
    SelectionImpl() {
        this.start = 0;
        this.end = 0;
    }
    @Override
    public int getBeginIndex() {
        return this.start;
    }

    @Override
    public int getEndIndex() {
        return this.end;
    }

    @Override
    public void setBeginIndex(int beginIndex) {
        this.start = beginIndex;
    }

    @Override
    public void setEndIndex(int endIndex) {
        this.end = endIndex;
    }
}
