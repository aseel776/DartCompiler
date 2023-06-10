package visitors;

public class SymbolTableInstance {
    public String id;
    public int parentHash;
    public String category;
    public int declarationLineNumber;

    public SymbolTableInstance(String id,
                               Integer parentHash,
                               String category,
                               Integer declarationLineNumber) {
        this.id = id;
        this.parentHash = parentHash;
        this.category = category;
        this.declarationLineNumber = declarationLineNumber;
    }

    public boolean equals(SymbolTableInstance obj) {
        boolean cond1 = (id.compareTo(obj.id) == 0);
        boolean cond2 = (parentHash == obj.parentHash);
        boolean cond3 = (category.compareTo(obj.category) == 0);
        boolean cond4 = (declarationLineNumber == obj.declarationLineNumber);
        return cond1 && cond2 && cond3 && cond4;
    }

    @Override
    public String toString() {
        return id + ":\n" + category + " at line " + declarationLineNumber;
    }
}
