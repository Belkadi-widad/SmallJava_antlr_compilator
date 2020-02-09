public class Elmt_TableSymbol {

    private String  type ;
    boolean declared , initialized ;
    private String value ;

    public Elmt_TableSymbol(String type, boolean declared, boolean initialized ,  String value) {
        this.type = type;
        this.declared = declared;
        this.value = value;
        this.initialized = initialized ;
    }
    public Elmt_TableSymbol(String type, boolean declared , boolean initialized) {
        this.type = type;
        this.declared = declared;
        this.initialized = initialized ;

    }

    public boolean isInitialized() {
        return initialized;
    }

    public String getType() {
        return type;
    }

    public boolean getDeclared() {
        return declared;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Element de la Table des Symbol{" +
                ", type='" + type + '\'' +
                ", declared='" + declared + '\'' +
                ", value=" + value +
                '}';
    }


    public void setType(String type) {
        this.type = type;
    }

    public void setDeclared(boolean declared) {
        this.declared = declared;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
