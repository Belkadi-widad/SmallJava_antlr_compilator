public class ElementQuad {
    static int   num_global=0  ;
    int  num_quad;
    int type_quad;// 0 : affectation | 1: expression | 2: condition | 3: ecriture  | 4: lecture |5: br
    String operateur , operande1,operande2 ,Tamporaire  ;

    public ElementQuad(int type,String operateur, String operande1, String operande2, String tamporaire) {
        num_global++;
        num_quad= num_global;
        this.type_quad=type;
        this.operateur = operateur;
        this.operande1 = operande1;
        this.operande2 = operande2;
        Tamporaire = tamporaire;
    }

    public String getOperateur() {
        return operateur;
    }

    public void setOperateur(String operateur) {
        this.operateur = operateur;
    }

    public String getOperande1() {
        return operande1;
    }
    public int  getNumQuad() {
        return num_quad;
    }

    public void setOperande1(String operande1) {
        this.operande1 = operande1;
    }

    public String getOperande2() {
        return operande2;
    }

    public void setOperande2(String operande2) {
        this.operande2 = operande2;
    }

    public String getTamporaire() {
        return Tamporaire;
    }

    public void setTamporaire(String tamporaire) {
        Tamporaire = tamporaire;
    }
}
