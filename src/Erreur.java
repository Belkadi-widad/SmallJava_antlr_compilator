public class Erreur {
    String categortie ;  // erreur 1 ou warninings 2
    String raison ;
    String text ;
    int line_error ;
    int column_error  ;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String	ANSI_ORANGE	= "\u001B[43m";

    /* Raison :
    * Compatibilité de types
    * Division par 0
    * Double déclaration
    *Non déclaré
    * Formatage non compatible
    *
    * */


    public String toString(int i) {
        String error="";
        if (categortie == "1") // erreur
        {

            error = ANSI_RED  +  " " + i +  "\t \t \t |" +  this.text + "\t |"+ this.line_error+ "\t \t \t  |" +this.column_error + "\t \t \t \t  |"
                    + this.raison  + " \n"  + ANSI_RESET;

        }
        else {
            error = ANSI_ORANGE  +  " " + i +  "\t \t \t |" +  this.text + "\t |"+ this.line_error+ "\t \t \t  |" +this.column_error + "\t \t \t \t  |"
                    + this.raison  + " \n"  + ANSI_RESET;
        }

        return error ;
    }


    public Erreur(String categortie, String raison, int line_error, int column_error , String text) {
        this.categortie = categortie;
        this.raison = raison;
        this.line_error = line_error;
        this.column_error = column_error;
        this.text = text ;
    }
}
