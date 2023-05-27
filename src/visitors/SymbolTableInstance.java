package visitors;

public class SymbolTableInstance {
    public String id;
    public Integer parentHash;
    public String toString;
    public Integer declarationLineNumber;

    public SymbolTableInstance(String id,
    Integer parentHash,
    String toString,
    Integer declarationLineNumber){
        this.id=id;
        this.parentHash=parentHash;
        this.toString=toString;
        this.declarationLineNumber=declarationLineNumber;
    }

}
