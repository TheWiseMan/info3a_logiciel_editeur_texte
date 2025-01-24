package fr.group1.wiseman.info3a.editor;

public interface AtomicOperation {
    void apply(Buffer buff);
    void mutate(AtomicOperation other);
    AtomicOperation reverse();
    String toString();
}
