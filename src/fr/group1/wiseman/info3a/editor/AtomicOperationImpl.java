package fr.group1.wiseman.info3a.editor;

public class AtomicOperationImpl implements AtomicOperation {
    private final String replacedText;
    private final String replacementText;
    private final int start;
    AtomicOperationImpl(Buffer buff, int from, int to, String replacement) {
        this.replacedText = buff.getRange(from, to);
        this.replacementText = replacement;
        this.start = from;
    }
    private AtomicOperationImpl(int from, String replacedText, String replacement) {
        this.replacedText = replacedText;
        this.replacementText = replacement;
        this.start = from;
    }

    /**
     * Applique l'opération au buffer buff.
     * @param buff the buffer to which the operation is applied
     */
    @Override
    public void apply(Buffer buff) {
        buff.setRange(this.start, this.start + this.replacedText.length(), this.replacementText);
    }

    /**
     * Modifie les paramètres de l'opération pour qu'elle s'éxecute correctement après l'opération other
     * @param other the reference operation
     */
    @Override
    public void mutate(AtomicOperation other) {
        // Implémentation naive :

    }

    /**
     * Renvoie l'opération permettant de défaire l'opération actuelle.
     * @return l'opération inverse
     */
    @Override
    public AtomicOperation reverse() {
        return new AtomicOperationImpl(this.start, this.replacementText, this.replacedText);
    }

    @Override
    public String toString() {
        return "(" + this.start + "," + (this.start + this.replacedText.length()) + ")\t'" + this.replacedText + "'\t->\t'" + this.replacementText + "'";
    }
}
