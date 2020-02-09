public class ElementCodeObjet {
    int num_elem;
    static int nb_elem =0;
    int num_quad;
    String operation;
    String destination;
    String source;

    public ElementCodeObjet( String operation, String destination, String source) {
        nb_elem++;
        this.num_elem = nb_elem;
        this.operation = operation;
        this.destination = destination;
        this.source = source;
    }


}
