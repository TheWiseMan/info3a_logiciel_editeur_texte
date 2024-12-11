package fr.group1.wiseman.info3a.editor;

public class BufferImpl implements Buffer {
    private String buffer;
    BufferImpl(String content) {
        buffer = content;
    }

    @Override
    public String getContent() {
        return buffer;
    }

    @Override
    public String getRange(int start, int end) {
        if (start > end) {
            start = start + end;
            end = start-end;
            start = start-end;
        }
        start = Math.max(start, 0);
        end = Math.min(end, this.buffer.length());
        return buffer.substring(start, end);
    }

    @Override
    public void setRange(int start, int end, String newContent) {
        this.buffer = this.buffer.substring(0, start) + newContent + this.buffer.substring(end);
    }

    @Override
    public int getBufferBeginIndex() {
        return 0;
    }

    @Override
    public int getBufferEndIndex() {
        return this.buffer.length();
    }
}
