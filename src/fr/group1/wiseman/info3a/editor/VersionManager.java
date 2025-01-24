package fr.group1.wiseman.info3a.editor;

public interface VersionManager {
    //private Vector<AtomicOperation> operation_history;
    void restoreVersion(Buffer buffer, String versionId);
    void addOperation(AtomicOperation op);
    void debugHistory();
    void undo(Buffer buffer);
}
